package se.kth.iv1350.sem.model;

/**
 * Represents a discount bound either to an item or a customer.
 */
public class DiscountDTO {
    private final float rate;

    /**
     * Creates an instance representing a discount.
     * @param rate Discount rate as percentage.
     */
    public DiscountDTO(float rate) {
        this.rate = rate;
    }

    /**
     * Get discount rate.
     * @return Discount rate as percentage.
     */
    public float getRate() {
        return this.rate;
    }
}
