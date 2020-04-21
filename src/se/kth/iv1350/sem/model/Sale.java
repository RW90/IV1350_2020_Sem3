package se.kth.iv1350.sem.model;

import java.util.ArrayList;

/**
 * Represents information about a sale occasion. Contains information about items in sale,
 * discounts and price.
 */
public class Sale {
    private int priceExcludingVAT;
    private int totalVAT;
    private int totalPrice;
    private ArrayList<Item> items;
    private DiscountDTO customerDiscount;

    /**
     * Creates a new instance of <code>Sale</code> class.
     */
    public Sale() {
        this.priceExcludingVAT = 0;
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.items = new ArrayList<Item>();
        this.customerDiscount = null;
    }

    /**
     * Add an item to the current sale and increment price accordingly.
     * @param item Item to add, represented by an <code>ItemInfoDTO</code>.
     * @param amount The amount of specified item to add.
     */
    public void addItem(ItemInfoDTO item, int amount) {
        //TODO: this
    }

    private boolean isItemInSale(ItemInfoDTO searchedItem) {
        for(Item itemInSale : items) {
            if (itemInSale.isItem(searchedItem)) {
                return true;
            }
        }
        return false;
    }
    


}
