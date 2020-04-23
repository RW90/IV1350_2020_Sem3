package se.kth.iv1350.sem.model;

/**
 * Meant to be a immutable version of <code>Item</code>. Represents a
 * collection of a particular item type.
 */
public class ItemDTO {
    private int amount;
    private ItemInfoDTO info;

    /**
     * Creates an instance by copying an existing <code>Item</code> object.
     * @param item <code>Item</code> to copy.
     */
    ItemDTO(Item item) {
        this.amount = item.getAmount();
        this.info = item.getInfo();
    }

    /**
     * Gets the amount of items in the collection,
     * @return Amount of items represented.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Gets the data for a singular item in the collection.
     * @return Data for a singular item in the collection.
     */
    public ItemInfoDTO getInfo() {
        return info;
    }
}
