package se.kth.iv1350.sem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a log of a sale that have taken place.
 */
public class SaleLogDTO {
    private int totalPrice;
    private int totalVat;
    private int payment;
    private int change;
    private ArrayList<Item> items;
    private StoreDTO store;
    private Date timeOfPurchase;

    public SaleLogDTO(Sale saleToLog, StoreDTO store, int payment, int change) {
        this.store = store;
        this.payment = payment;
        this.change = change;
        this.totalPrice = saleToLog.getTotalPrice();
        this.totalVat = saleToLog.getTotalVAT();
        this.items = saleToLog.getItems();
        this.timeOfPurchase = new Date();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getTotalVat() {
        return totalVat;
    }

    public int getPayment() {
        return payment;
    }

    public int getChange() {
        return change;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public StoreDTO getStore() {
        return store;
    }

    public Date getTimeOfPurchase() {
        return timeOfPurchase;
    }
}
