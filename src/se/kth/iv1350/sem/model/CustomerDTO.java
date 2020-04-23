package se.kth.iv1350.sem.model;

/**
 * Represents a customer with its discounts. Stub class, only used in the integration layer
 * that is not properly implemented.
 */
public class CustomerDTO {
    private String id;
    private DiscountDTO discount;

    /**
     * Creates a new instance of a customer.
     * @param id Unique identifier for the customer.
     * @param discount A possible discount for the customer.
     */
    public CustomerDTO(String id, DiscountDTO discount) {
        this.id = id;
        this.discount = discount;
    }

    /**
     * Get the customers id.
     * @return Unique id of the customer.
     */
    public String getId() {
        return id;
    }

    /**
     * Get the customers discount, if it has any.
     * @return Customers discount.
     */
    public DiscountDTO getDiscount() {
        return discount;
    }
}
