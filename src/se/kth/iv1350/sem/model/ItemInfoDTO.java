package se.kth.iv1350.sem.model;

/**
 * Class representing data for an item. Instances are immutable.
 */
public class ItemInfoDTO {
    private final int price;
    private final float VATRate;
    private  final String description;
    private final int id;
    private final String name;

    /**
     * Creates a new immutable instance of ItemInfoDTO, representing a unique item.
     * @param price Price of item.
     * @param VATRate Tax-rate in percentage of item.
     * @param description Description of item.
     * @param id Unique id-number of item.
     * @param name Item name.
     */
    public ItemInfoDTO(int price, float VATRate, String description, int id, String name) {
        this.price = price;
        this.VATRate = VATRate;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    /**
     * Get item price.
     * @return Item price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get item tax rate as percentage.
     * @return Item tax rate.
     */
    public float getVATRate() {
        return VATRate;
    }

    /**
     * Get item description.
     * @return Item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get item id-number which uniquely identifies it.
     * @return Item id-number.
     */
    public int getId() {
        return id;
    }

    /**
     * Get item name.
     * @return Item name.
     */
    public String getName() {
        return name;
    }
}
