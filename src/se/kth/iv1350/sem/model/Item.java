package se.kth.iv1350.sem.model;

/**
 * Represents a collection of a specific item.
 */
public class Item {
    private int amount;
    private ItemInfoDTO info;

    /**
     * Creates a new instance representing a collection of items.
     * @param amount Number of items.
     * @param info Information describing a single item in the collection.
     */
    public Item (int amount, ItemInfoDTO info) {
        this.amount = amount;
        this.info = info;
    }

    /**
     * Adds the amount sent to the item amount. Positive argument increase item amount, negative decrease.
     * @param amount Amount to change item amount by.
     */
    void addAmount(int amount) {
        this.amount += amount;
    }

    /**
     * Decrements the amount field with the amount given as parameter.
     * @param amount Amount to change item amount by.
     */
    public void decreaseAmount(int amount) {
        addAmount(-amount);
    }

    /**
     * Checks if this item is a collection of items specified by an <code>ItemInfoDTO</code>. <code>true</code> if
     * this items <code>ItemInfoDTO</code> id is equal to the sent in <code>ItemInfoDTO</code>.
     * @param item Info to compare to.
     * @return <code>true</code> if item id's are equal, false otherwise.
     */
    boolean isItem(ItemInfoDTO item) {
        return this.info.getId() == item.getId();
    }

    /**
     * Checks if this collection of items is a collection of items specified by the same <code>ItemInfoDTO</code>.
     * <code>true</code> if this items <code>ItemInfoDTO</code> id is equal to the sent in <code>ItemInfoDTO</code>.
     * @param item Item to compare to.
     * @return <code>true</code> if item id's are equal, false otherwise.
     */
    public boolean isItem(ItemDTO item) {
        return isItem(item.getInfo());
    }

    /**
     * Checks if this collection of items is a collection of items specified by the same <code>ItemInfoDTO</code>.
     * <code>true</code> if this items <code>ItemInfoDTO</code> id is equal to the sent in <code>ItemInfoDTO</code>.
     * @param item Item to compare to.
     * @return <code>true</code> if item id's are equal, false otherwise.
     */
    public boolean isItem(Item item) {
        return isItem(item.getInfo());
    }

    /**
     * Get the amount of items.
     * @return The item amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Get the information of the specific item in this collection.
     * @return Item information.
     */
    public ItemInfoDTO getInfo() {
        return info;
    }
}
