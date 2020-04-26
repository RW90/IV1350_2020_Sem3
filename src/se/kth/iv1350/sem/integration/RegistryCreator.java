package se.kth.iv1350.sem.integration;

/**
 * Creates the different external system arbiters to encapsulate the integration layer better.
 */
public class RegistryCreator {
    private CustomerRegistry customerRegistry;
    private ItemRegistry itemRegistry;
    private SaleRegistry saleRegistry;

    /**
     * Creates an instance of registry creator which in turn creates instances of
     * <code>CustomerRegistry</code>, <code>ItemRegistry</code> and <code>SaleRegistry</code>
     * objects to be retrieved.
     */
    public RegistryCreator() {
        this.customerRegistry = new CustomerRegistry();
        this.itemRegistry = new ItemRegistry();
        this.saleRegistry = new SaleRegistry();
    }

    /**
     * Get the <code>CustomerRegistry</code> instance.
     * @return <code>CustomerRegistry</code> instance.
     */
    public CustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    /**
     * Get the <code>ItemRegistry</code> instance.
     * @return <code>ItemRegistry</code> instance.
     */
    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    /**
     * Get the <code>SaleRegistry</code> instance.
     * @return <code>SaleRegistry</code> instance.
     */
    public SaleRegistry getSaleRegistry() {
        return saleRegistry;
    }
}
