package se.kth.iv1350.sem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a log of a sale that have taken place.
 * Contains data meant for a receipt and accounting systems.
 */
public class SaleLogDTO {
    private int totalPrice;
    private int totalVat;
    private int payment;
    private int change;
    private ArrayList<ItemDTO> items;
    private StoreDTO store;
    private Date timeOfPurchase;

    /**
     * Creates an instance of <code>SaleLogDTO</code>
     * @param saleToLog <code>Sale</code> object to log to a receipt and accounting systems.
     * @param store Store that sale took place in.
     * @param payment Payment received from the customer.
     * @param change Amount of money to give back to customer.
     */
    SaleLogDTO(Sale saleToLog, StoreDTO store, int payment, int change) {
        this.store = store;
        this.payment = payment;
        this.change = change;
        this.totalPrice = saleToLog.getTotalPrice();
        this.totalVat = saleToLog.getTotalVAT();
        this.items = saleToLog.getItems();
        this.timeOfPurchase = new Date();
    }

    /**
     * Gets the total price of the logged sale occasion.
     * @return Sale price including VAT.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the total VAT price of the logged sale occasion.
     * @return VAT amount.
     */
    public int getTotalVat() {
        return totalVat;
    }

    /**
     * Gets the payment recieved from the customer of the logged sale occasion.
     * @return Payment received from customer.
     */
    public int getPayment() {
        return payment;
    }

    /**
     * Gets the change owed back to the customer of the logged sale occasion.
     * @return Change owed back to the customer.
     */
    public int getChange() {
        return change;
    }

    /**
     * Gets the items sold of the logged sale occasion.
     * @return <code>ArrayList</code> of <code>ItemDTO</code> of sold items.
     */
    public ArrayList<ItemDTO> getItems() {
        ArrayList<ItemDTO> returnItems = new ArrayList<ItemDTO>();
        for(ItemDTO item : items){
            returnItems.add(item);
        }
        return returnItems;
    }

    /**
     * Gets the store where the logged sale occasion occurred.
     * @return Store info.
     */
    public StoreDTO getStore() {
        return store;
    }

    /**
     * Gets the time and date of the logged sale occasion.
     * @return <code>Date</code> object when the sale happened.
     */
    public Date getTimeOfPurchase() {
        return timeOfPurchase;
    }
}
