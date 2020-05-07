package se.kth.iv1350.sem.view;

import se.kth.iv1350.sem.model.SaleObserver;

/**
 * Observing sales and sending data to a separate display.
 */
public class TotalRevenueView implements SaleObserver {
    private int totalRevenue;

    /**
     * Creates a new instance and sets the revenue to 0.
     */
    public TotalRevenueView() {
        this.totalRevenue = 0;
    }
    /**
     * Updates the observer with a finished sale. and displays the updated total revenue to the screen.
     *
     * @param price <code>Price</code> to observe.
     */
    @Override
    public void saleHasFinished(int price) {
        this.totalRevenue += price;
        System.out.println("Displaying on total revenue display:");
        System.out.println("Total revenue since system start: " + this.totalRevenue);
    }
}
