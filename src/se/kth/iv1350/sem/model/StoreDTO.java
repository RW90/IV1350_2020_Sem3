package se.kth.iv1350.sem.model;

/**
 * Represents a physical grocery store.
 */
public class StoreDTO {
    private final String adress;
    private final String name;

    /**
     * Creates an instance representing a physical store at location adress and named name.
     * @param adress Adress of the store.
     * @param name Name of the store.
     */
    public StoreDTO(String adress, String name) {
        this.adress = adress;
        this.name = name;
    }

    /**
     * Get store adress.
     * @return Store adress.
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Get store name.
     * @return Store name.
     */
    public String getName() {
        return name;
    }
}
