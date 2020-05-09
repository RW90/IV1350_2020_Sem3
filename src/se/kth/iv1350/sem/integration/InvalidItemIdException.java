package se.kth.iv1350.sem.integration;

/**
 * Thrown when failing to find an item in the item registry external system that was scanned in.
 */
public class InvalidItemIdException extends Exception {
    private int itemId;

    /**
     * Creates a new instance of <code>InvalidItemIdException</code>.
     * @param itemId Item id that wasn't in the database.
     */
    public InvalidItemIdException(String msg, int itemId) {
        super(msg);
        this.itemId = itemId;
    }

    /**
     * Get the invalid item id that caused the exception to be thrown.
     * @return Item id that caused the exception.
     */
    public int getItemId() {
        return itemId;
    }
}
