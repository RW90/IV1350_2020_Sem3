package se.kth.iv1350.sem.integration;

import se.kth.iv1350.sem.model.*;

import java.util.ArrayList;

public class ItemRegistry {
    private ArrayList<Item> itemsInDB;

    ItemRegistry() {
        itemsInDB = new ArrayList<Item>();
        addItemsToMockDB();
    }

    private void addItemsToMockDB() {
        ItemInfoDTO itemInfoToAdd1 = new ItemInfoDTO(100, 0.25f, "Norsk odlad lax.", 1, "Lax", null);
        ItemInfoDTO itemInfoToAdd2 = new ItemInfoDTO(5, 0.125f, "Pink lady, Ekologisk.", 2, "Äpple", null);
        DiscountDTO discountForItem = new DiscountDTO(0.8f);
        ItemInfoDTO itemInfoToAdd3 = new ItemInfoDTO(20, 0.25f, "Kakaohalt 70%", 3, "Choklad", discountForItem);
        Item itemToAdd1 = new Item(10, itemInfoToAdd1);
        Item itemToAdd2 = new Item(50, itemInfoToAdd2);
        Item itemToAdd3 = new Item(30, itemInfoToAdd3);
        itemsInDB.add(itemToAdd1);
        itemsInDB.add(itemToAdd2);
        itemsInDB.add(itemToAdd3);
    }

    /**
     * Fetches an items info from the mock DB.
     * @param id Id of item to fetch.
     * @return <code>ItemInfoDTO</code> object containing fetched item info.
     * @throws DatabaseConnectionFailureException When system is unable to communicate with the external server (mock implementation)
     * @throws InvalidItemIdException When item with id can't be found in the database.
     */

    public ItemInfoDTO fetchItem(int id) throws InvalidItemIdException{
        if(id == -10) {
            throw new DatabaseConnectionFailureException("ERR CODE 000: Connection time out with item registry.");
        }
        ItemInfoDTO returnItem = null;
        for(Item itemInDb : itemsInDB) {
            if(itemInDb.getInfo().getId() == id) {
                returnItem = itemInDb.getInfo();
                return returnItem;
            }
        }
        throw new InvalidItemIdException("Item not found in database", id);
    }

    /**
     * Updates the mock DB with items sold in a sale occasion. Decrement
     * <code>Item</code> amounts in the DB.
     * @param saleToLog <code>SaleLogDTO</code> to update the mock DB with.
     */
    public void updateInventory(SaleLogDTO saleToLog) {
        ArrayList<ItemDTO> itemsToLog = saleToLog.getItems();
        for(ItemDTO itemToLog : itemsToLog) {
            for(Item itemInDB : itemsInDB) {
                if(itemInDB.isItem(itemToLog)) {
                    itemInDB.decreaseAmount(itemToLog.getAmount());
                    break;
                }
            }
        }
    }



}
