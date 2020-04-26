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
     * Creates a new empty instance of <code>Sale</code> class. Initiates prices to 0.
     */
    public Sale() {
        this.priceExcludingVAT = 0;
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.items = new ArrayList<Item>();
        this.customerDiscount = null;
    }

    /**
     * Returns the price of the VAT of the sale.
     * @return The VAT amount.
     */
    public int getTotalVAT() {
        return totalVAT;
    }

    /**
     * Returns the price of the sale including VAT.
     * @return Total price of the sale.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the <code>Item</code> objects added to the
     * sale in an <code>ArrayList</code> of <code>ItemDTO</code> objects.
     * @return <code>ArrayList</code> of <code>ItemDTO</code> representing this sales items.
     */
    public ArrayList<ItemDTO> getItems() {
        ArrayList<ItemDTO> returnItems = new ArrayList<ItemDTO>();
        for(Item itemToCopy : items) {
            ItemDTO copiedItem = new ItemDTO(itemToCopy);
            returnItems.add(copiedItem);
        }
        return returnItems;
    }

    /**
     * Gets the discount of the customer doing the sale.
     * @return Discount as a <code>DiscountDTO</code> object.
     */
    public DiscountDTO getCustomerDiscount() {
        return customerDiscount;
    }

    /**
     * Adds a discount to the <code>Sale</code> in form of a <code>DiscountDTO</code>
     * and applies its rate to the price.
     * @param discount Discount to apply.
     */
    public void addDiscount(DiscountDTO discount) {
        customerDiscount = discount;
        totalVAT = (int)(totalVAT * customerDiscount.getRate());
        priceExcludingVAT = (int) (priceExcludingVAT * customerDiscount.getRate());
        totalPrice = totalVAT + priceExcludingVAT;
    }

    /**
     * Add an item to the current sale and increment price accordingly. Returns the amount
     * of the item currently in the sale.
     * @param item Item to add, represented by an <code>ItemInfoDTO</code>.
     * @param amount The amount of specified item to add.
     * @return The updated amount of the item added in sale(after potential increased amount).
     */
    public int addItem(ItemInfoDTO item, int amount) {
        int itemAmountInSale = amount;
        if(isItemInSale(item)) {
            itemAmountInSale = increaseItemAmount(item, amount);
        } else {
            addNewItem(item, amount);
        }
        increasePrice(item, amount);
        return itemAmountInSale;
    }

    private void increasePrice(ItemInfoDTO item, int amount) {
        int itemPrice = item.getPrice() * amount;
        int VATPrice = (int) (item.getPrice() * item.getVATRate() * amount);
        if(item.getDiscount() != null) {
            itemPrice = (int) (itemPrice * item.getDiscount().getRate());
            VATPrice = (int) (VATPrice * item.getDiscount().getRate());
        }
        this.priceExcludingVAT += itemPrice;
        this.totalVAT += VATPrice;
        this.totalPrice = this.priceExcludingVAT + this.totalVAT;
    }

    private void addNewItem(ItemInfoDTO item, int amount) {
        Item newItem = new Item(amount, item);
        items.add(newItem);
    }

    private int increaseItemAmount(ItemInfoDTO item, int amount) {
        int itemIndex = findIndexOfItem(item);
        Item itemToIncrement = items.get(itemIndex);
        itemToIncrement.addAmount(amount);
        return itemToIncrement.getAmount();
    }

    private boolean isItemInSale(ItemInfoDTO searchedItem) {
        return findIndexOfItem(searchedItem) != -1;
    }

    private int findIndexOfItem(ItemInfoDTO itemToFind) {
        int index = 0;
        for(Item itemInSale : items) {
            if(itemInSale.isItem(itemToFind)) {
                return index;
            }
            index++;
        }
        return -1;
    }
    


}
