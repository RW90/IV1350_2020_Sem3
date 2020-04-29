package se.kth.iv1350.sem.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem.integration.Printer;
import se.kth.iv1350.sem.integration.RegistryCreator;
import se.kth.iv1350.sem.model.DiscountDTO;
import se.kth.iv1350.sem.model.ItemInfoDTO;
import se.kth.iv1350.sem.model.SaleStatusDTO;
import se.kth.iv1350.sem.model.StoreDTO;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller testObj;
    @BeforeEach
    void setUp() {
        testObj = new Controller(new RegistryCreator(), new Printer(), new StoreDTO("Test adress", "Test name"));
        testObj.newSale();
    }

    @AfterEach
    void tearDown() {
        testObj = null;
    }

    @Test
    void scanValidItem() {
        int expAmount = 1;
        int expItemId = 1;
        SaleStatusDTO testStatus = testObj.scanItem(expItemId, expAmount);
        int resItemAmount = testStatus.getAmount();
        boolean resValidId = testStatus.isValidItem();
        int resPrice = testStatus.getSalePrice();
        int resItemId = testStatus.getItemInfo().getId();
        int expPrice = testStatus.getItemInfo().getPrice() + (int) (testStatus.getItemInfo().getPrice() * testStatus.getItemInfo().getVATRate());

        assertEquals(expAmount, resItemAmount, "Wrong item amount in sale");
        assertEquals(expItemId, resItemId, "Wrong item id in sale");
        assertEquals(expPrice, resPrice, "Wrong price in sale");
        assertTrue(resValidId, "Valid item flags invalid sale status.");
    }

    @Test
    void scanInvalidItem() {
        SaleStatusDTO testStatus = testObj.scanItem(-1, 1);
        int expAmount = 0;
        int resItemAmount = testStatus.getAmount();
        boolean resValidId = testStatus.isValidItem();
        int resPrice = testStatus.getSalePrice();
        boolean resItemInfo = testStatus.getItemInfo() instanceof ItemInfoDTO;
        int expPrice = 0;

        assertEquals(expAmount, resItemAmount, "Item gets added to sale even though it's id is invalid");
        assertEquals(expPrice, resPrice, "Item price gets added to sale even though it's id is invalid");
        assertFalse(resValidId, "Invalid item flags valid sale status.");
        assertFalse(resItemInfo, "Invalid id fetches an ItemInfoDTO.");
    }

    @Test
    void discountValidRequest() {
        int priceBefore = testObj.scanItem(1, 10).getSalePrice();
        int expPrice = (int)(priceBefore * 0.8f);
        int resPrice= testObj.discountRequest("Anna");
        assertEquals(expPrice, resPrice, "Adding a discount gives the wrong price.");
    }

    @Test
    void discountInvalidRequest() {
        int expPrice = testObj.scanItem(1, 10).getSalePrice();
        int resPrice= testObj.discountRequest("Leif");
        assertEquals(expPrice, resPrice, "Adding an invalid discount changes the price.");
    }

    @Test
    void exactPayment() {
        int salePrice = testObj.scanItem(1, 10).getSalePrice();
        int res = testObj.payment(salePrice);
        int expRes = 0;
        assertEquals(expRes, res, "Paying the exact amount gives wrong change.");
    }

    @Test
    void overPayment() {
        int salePrice = testObj.scanItem(1, 10).getSalePrice();
        int expRes = 100;
        int res = testObj.payment(salePrice + expRes);
        assertEquals(expRes, res, "Overpaying gives wrong change.");
    }
}