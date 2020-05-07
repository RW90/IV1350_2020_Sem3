package se.kth.iv1350.sem.model;

/**
 * DTO meant to carry data about an ongoing sale and status about the scanned
 * in item from the system to the UI.
 */
public class SaleStatusDTO {
    private ItemInfoDTO itemInfo;
    private int salePrice;
    private int amount;

    /**
     * Creates an instance of <code>SaleStatusDTO</code> representing the state of the
     * ongoing sale after an item have been scanned in.
     * @param itemInfo Info about item just scanned in.
     * @param salePrice Running total of the ongoing sale.
     * @param amount Amount of the scanned in item in the ongoing sale. 0 if item wasn't valid.
     */
    public SaleStatusDTO(ItemInfoDTO itemInfo, int salePrice, int amount) {
        this.itemInfo = itemInfo;
        this.salePrice = salePrice;
        this.amount = amount;
    }

    /**
     * Get scanned in item info. <code>null</code> if item scanned in was invalid.
     * @return Scanned in item info.
     */
    public ItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    /**
     * Gets running total for current sale.
     * @return Running total.
     */
    public int getSalePrice() {
        return salePrice;
    }

    /**
     * Get amount of item that was scanned in.
     * @return Amount of item scanned in.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Returns <code>String</code> representation of object, displaying if item is valid or not.
     * @return <code>String</code> representation of object.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(amount);
        builder.append("x\t" + itemInfo.getName() + "\n");
        builder.append("Item description:\n" + itemInfo.getDescription() + "\n");
        builder.append("Running total: ");
        builder.append(salePrice);
        builder.append("\n");
        return builder.toString();
    }
}
