package se.kth.iv1350.sem.model;

/**
 * Represents data for an item. Instances are immutable.
 */
public class ItemInfoDTO {
    private final int price;
    private final float VATRate;
    private  final String description;
    private final int id;
    private final String name;
    private final DiscountDTO discount;

    /**
     * Creates a new immutable instance of ItemInfoDTO, representing data of an unique item.
     * @param price Price of item.
     * @param VATRate Tax-rate in percentage of item.
     * @param description Description of item.
     * @param id Unique id-number of item.
     * @param name Item name.
     * @param discount  Item discount as a <code>DiscountDTO</code> object. <code>null</code> if it has no discount.
     */
    public ItemInfoDTO(int price, float VATRate, String description, int id, String name, DiscountDTO discount) {
        this.price = price;
        this.VATRate = VATRate;
        this.description = description;
        this.id = id;
        this.name = name;
        this.discount = discount;
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

    /**
     * Get item discount.
     * @return Item discount.
     */
    public DiscountDTO getDiscount() {
        return this.discount;
    }
}
