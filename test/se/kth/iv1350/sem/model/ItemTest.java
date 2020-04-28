package se.kth.iv1350.sem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item testObj;
    @BeforeEach
    void setUp() {
        testObj = new Item(10, new ItemInfoDTO(20, 0.25f, "Test item decription.", 5, "Test item name", new DiscountDTO(0.8f)));
    }

    @AfterEach
    void tearDown() {
        testObj = null;
    }

    @Test
    void addAmount() {
        testObj.addAmount(5);
        int res = testObj.getAmount();
        int expRes = 10 + 5;
        assertEquals(res, expRes, "addAmouunt with positive amount doesn't add correctly.");
    }

    @Test
    void addZeroAmount() {
        testObj.addAmount(0);
        int res = testObj.getAmount();
        int expRes = 10;
        assertEquals(res, expRes, "addAmount with zero amount doesn't add correctly.");
    }

    @Test
    void decreaseAmount() {
        testObj.decreaseAmount(5);
        int res = testObj.getAmount();
        int expRes = 10 - 5;
        assertEquals(res, expRes, "decreaseAmount with positive amount doesn't decrease correctly.");
    }

    @Test
    void decreaseZeroAmount() {
        testObj.decreaseAmount(0);
        int res = testObj.getAmount();
        int expRes = 10;
        assertEquals(res, expRes, "decreaseAmount with zero amount doesn't decrease correctly.");
    }

    @Test
    void isItemItemInfoDTO() {
        ItemInfoDTO testComp = new ItemInfoDTO(20, 0.25f, "Test item decription.", 5, "Test item name", new DiscountDTO(0.8f));
        boolean res = testObj.isItem(testComp);
        boolean expRes = true;
        assertEquals(res, expRes, "isItem returning false for equal ItemInfoDTO");
    }

    @Test
    void isItemWrongItemInfoDTO() {
        ItemInfoDTO testComp = new ItemInfoDTO(20, 0.25f, "Test item decription.", 1, "Test item name", new DiscountDTO(0.8f));
        boolean res = testObj.isItem(testComp);
        boolean expRes = false;
        assertEquals(res, expRes, "isItem returning true for wrong ItemInfoDTO");
    }

    @Test
    void testIsItemItem() {
        Item testComp = new Item(10, new ItemInfoDTO(20, 0.25f, "Test item decription.", 5, "Test item name", new DiscountDTO(0.8f)));
        boolean res = testObj.isItem(testComp);
        boolean expRes = true;
        assertEquals(res, expRes, "isItem returning true for wrong Item");
    }

    @Test
    void testIsItemWrongItem() {
        Item testComp = new Item(10, new ItemInfoDTO(20, 0.25f, "Test item description.", 3, "Test item name", new DiscountDTO(0.8f)));
        boolean res = testObj.isItem(testComp);
        boolean expRes = false;
        assertEquals(res, expRes, "isItem returning true for wrong Item");
    }


    @Test
    void testIsItemItemDTO() {
        Item testItem = new Item(10, new ItemInfoDTO(20, 0.25f, "Test item description.", 5, "Test item name", new DiscountDTO(0.8f)));
        ItemDTO testComp = new ItemDTO(testItem);
        boolean res = testObj.isItem(testComp);
        boolean expRes = true;
        assertEquals(res, expRes, "isItem returning false for correct ItemDTO");
    }

    @Test
    void testIsItemWrongItemDTO() {
        Item testItem = new Item(10, new ItemInfoDTO(20, 0.25f, "Test item description.", 3, "Test item name", new DiscountDTO(0.8f)));
        ItemDTO testComp = new ItemDTO(testItem);
        boolean res = testObj.isItem(testComp);
        boolean expRes = false;
        assertEquals(res, expRes, "isItem returning true for wrong ItemDTO");
    }
}