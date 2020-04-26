package se.kth.iv1350.sem.controller;

import se.kth.iv1350.sem.integration.*;
import se.kth.iv1350.sem.model.CashRegister;
import se.kth.iv1350.sem.model.Sale;
import se.kth.iv1350.sem.model.StoreDTO;

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

}
