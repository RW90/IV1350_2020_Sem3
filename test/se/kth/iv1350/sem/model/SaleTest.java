package se.kth.iv1350.sem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale testObj;
    @BeforeEach
    void setUp() {
        testObj = new Sale();
        ItemInfoDTO item1 = new ItemInfoDTO(20, 0.25f, "Test item 1 decription.", 1, "Test item 1 name", new DiscountDTO(0.8f));
        ItemInfoDTO item2 = new ItemInfoDTO(10, 0.125f, "Test item 2 decription.", 2, "Test item 2 name", null);
        testObj.addItem(item1, 3);
        testObj.addItem(item2, 5);
    }

    @AfterEach
    void tearDown() {
        testObj = null;
    }

    @Test
    void addDiscount() {
        DiscountDTO testDisc = new DiscountDTO(0.8f);
        int expRes = (int) (testObj.getTotalPrice() * 0.8f);
        testObj.addDiscount(testDisc);
        int res = testObj.getTotalPrice();
        assertEquals(res, expRes, "Adding discount gives wrong total price.");
    }

    @Test
    void addNewItem() {
        ItemInfoDTO testItem = new ItemInfoDTO(10, 0.125f, "Test item 3 decription.", 5, "Test item 3 name", null);
        int expPrice = testObj.getTotalPrice() + 2 * (testItem.getPrice() + (int)(testItem.getPrice() * testItem.getVATRate()));
        testObj.addItem(testItem, 2);
        int resPrice = testObj.getTotalPrice();
        ArrayList<ItemDTO> resItem = testObj.getItems();
        int resLength = resItem.size();
        int expLength = 3;
        assertEquals(resLength, expLength, "New item is not getting added to item array.");
        assertEquals(resPrice, expPrice, "New item price is not added correctly");
    }

    @Test
    void addNewItemWithDiscount() {
        ItemInfoDTO testItem = new ItemInfoDTO(10, 0.125f, "Test item 3 decription.", 5, "Test item 3 name", new DiscountDTO(0.9f));
        int expPrice =  2 * testItem.getPrice() + (int) (testItem.getPrice() * testItem.getVATRate() * 2);
        expPrice = (int) (expPrice * testItem.getDiscount().getRate());
        expPrice += testObj.getTotalPrice();
        testObj.addItem(testItem, 2);
        int resPrice = testObj.getTotalPrice();
        ArrayList<ItemDTO> resItem = testObj.getItems();
        int resLength = resItem.size();
        int expLength = 3;
        assertEquals(resLength, expLength, "New item is not getting added to item array.");
        assertEquals(resPrice, expPrice, "New item price is not added correctly");
    }

    @Test
    void addSameItem() {
        ItemInfoDTO testItem = new ItemInfoDTO(10, 0.125f, "Test item 2 decription.", 2, "Test item 2 name", null);
        int expPrice = testObj.getTotalPrice() + 2 * (testItem.getPrice() + (int)(testItem.getPrice() * testItem.getVATRate()));
        int resAmount = testObj.addItem(testItem, 2);
        int resPrice = testObj.getTotalPrice();
        ArrayList<ItemDTO> resItem = testObj.getItems();
        int resLength = resItem.size();
        int expLength = 2;
        int expAmount = 5 + 2;
        assertEquals(resLength, expLength, "New item is not getting added to item array.");
        assertEquals(resPrice, expPrice, "Same item price is not added correctly");
        assertEquals(resAmount, expAmount, "Adding item doesn't add upp amount");
    }

    @Test
    void finishSaleTest() {
        SaleLogDTO loggedSale = testObj.finishSale(new StoreDTO("Test adress", "Test name"), 500, 500);
        boolean res = loggedSale instanceof SaleLogDTO;
        assertTrue(res, "finishSale doesn't return a sale log.");
    }
}