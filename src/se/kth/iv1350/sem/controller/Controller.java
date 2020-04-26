package se.kth.iv1350.sem.controller;

import se.kth.iv1350.sem.integration.*;
import se.kth.iv1350.sem.model.*;

/**
 * This systems only controller. All calls to model and integration layer pass through this controller.
 */
public class Controller {
    private SaleRegistry saleRegistry;
    private CustomerRegistry customerRegistry;
    private ItemRegistry itemRegistry;
    private Printer printer;
    private StoreDTO storeInfo;
    private CashRegister cashRegister;
    private Sale currentSale;

    /**
     * Instantiates the controller with references the to integration and model layer that it needs.
     * @param registries Used to deliver references to the registries in the integration layer.
     * @param printer Handles printer interaction.
     * @param storeInfo The current store the system operates in.
     */
    public Controller(RegistryCreator registries, Printer printer, StoreDTO storeInfo) {
        this.saleRegistry = registries.getSaleRegistry();
        this.customerRegistry = registries.getCustomerRegistry();
        this.itemRegistry = registries.getItemRegistry();
        this.printer = printer;
        this.storeInfo = storeInfo;
        this.cashRegister = new CashRegister();
        this.currentSale = null;
    }

    /**
     * Initializes a new sale that the program keeps track of. Must be done before any other sale operation.
     */
    public void newSale() {
        this.currentSale = new Sale();
    }

    /**
     * Function to be called by UI when scanning an item. Will add the item(if valid) to the ongoing <code>Sale</code>,
     * increasing the running total and returning information about the sale in an <code>SaleStatusDTO</code> instance.
     * @param itemId Scanned item id.
     * @param amount Amount of items to be entered into ongoing sale.
     * @return Sale status to be displayed by UI as a <code>SaleStatusDTO</code> object.
     */
    public SaleStatusDTO scanItem(int itemId, int amount) {
        ItemInfoDTO fetchedItem = itemRegistry.fetchItem(itemId);
        int itemAmount = 0;
        boolean validItem = fetchedItem != null;
        if(validItem) {
            itemAmount = currentSale.addItem(fetchedItem, amount);
        }
        int runningTotal = getSalePrice();
        SaleStatusDTO saleStatus = new SaleStatusDTO(validItem, fetchedItem, runningTotal, itemAmount);
        return saleStatus;
    }

    /**
     * To be signaled at the end of a sale occasion.
     * @return Total price of the ongoing sale.
     */
    public int endSale() {
        return getSalePrice();
    }

    /**
     * Checks if a customer with customerId has a discount, and if so, applies it to the ongoing sale.
     * @param customerId Id of the customer making the discount request.
     * @return Running total of ongoing sale.
     */
    public int discountRequest(String customerId) {
        DiscountDTO customerDiscount = customerRegistry.fetchCustomerDiscount(customerId);
        if(customerDiscount != null) {
            currentSale.addDiscount(customerDiscount);
        }
        return getSalePrice();
    }

    /**
     * Enters a payment into the system, finishing the current ongoing sale.
     * @param payAmount The amount received by the paying customer.
     * @return The amount of change owed to the customer.
     */
    public int payment(int payAmount) {
        int salePrice = getSalePrice();
        int change = cashRegister.updateBalance(salePrice, payAmount);
        SaleLogDTO saleLog = new SaleLogDTO(currentSale, storeInfo, payAmount, change);
        logSale(saleLog);
        return change;
    }

    private void logSale(SaleLogDTO saleLog) {
        itemRegistry.updateInventory(saleLog);
        saleRegistry.logSale(saleLog);
        printer.printReceipt(saleLog);
    }

    private int getSalePrice() {
        return currentSale.getTotalPrice();
    }

}
