package se.kth.iv1350.sem.model;

/**
 * Observer pattern interface for observing sales.
 */
public interface SaleObserver {

    /**
     * Updates the observer with a price.
     * @param price Price to update observer with.
     */
    public void saleHasFinished(int price);
}
