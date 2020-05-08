package se.kth.iv1350.sem.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem.integration.*;
import se.kth.iv1350.sem.model.*;
import se.kth.iv1350.sem.view.TotalRevenueView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller testObj;
    @BeforeEach
    void setUp() {
        testObj = new Controller(new RegistryCreator(), new Printer(), new StoreDTO("Test adress", "Test name"), new ExceptionLogHandler(), new ArrayList<SaleObserver>());
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
        SaleStatusDTO testStatus = null;
        try {
            testStatus = testObj.scanItem(expItemId, expAmount);
        } catch (Exception e) {
            fail("Unable to fetch valid item.");
        }
        int resItemAmount = testStatus.getAmount();
        int resPrice = testStatus.getSalePrice();
        int resItemId = testStatus.getItemInfo().getId();
        int expPrice = testStatus.getItemInfo().getPrice() + (int) (testStatus.getItemInfo().getPrice() * testStatus.getItemInfo().getVATRate());

        assertEquals(expAmount, resItemAmount, "Wrong item amount in sale");
        assertEquals(expItemId, resItemId, "Wrong item id in sale");
        assertEquals(expPrice, resPrice, "Wrong price in sale");
    }

    @Test
    void scanInvalidItem() {
        SaleStatusDTO testStatus = null;
        try {
            testStatus = testObj.scanItem(-1, 1);
            fail("Able to fetch invalid item id");
        } catch (InvalidItemIdException e) {
            assertNull(testStatus, "Teststatus created when invalid item was scanned.");
        }
    }

    @Test
    void simulateDatabaseFailure() {
        SaleStatusDTO testStatus = null;
        try {
            testStatus = testObj.scanItem(-10, 1);
            fail("Able to fetch when database connection is failing.");
        } catch (Exception e) {
            boolean res = e instanceof DatabaseConnectionFailureException;
            assertTrue(res, "Wrong exception thrown on database failure.");
        }
    }

    @Test
    void discountValidRequest() {
        int priceBefore = 0;
        try {
            priceBefore = testObj.scanItem(1, 10).getSalePrice();
        } catch (Exception e) {
            fail("Exception thrown when doing legitimate action");
        }
        int expPrice = (int)(priceBefore * 0.8f);
        int resPrice= testObj.discountRequest("Anna");
        assertEquals(expPrice, resPrice, "Adding a discount gives the wrong price.");
    }

    @Test
    void discountInvalidRequest() {
        int expPrice = 0;
        try {
            expPrice = testObj.scanItem(1, 10).getSalePrice();
        } catch (Exception e) {
            fail("Exception thrown when doing legitimate action");
        }
        int resPrice= testObj.discountRequest("Leif");
        assertEquals(expPrice, resPrice, "Adding an invalid discount changes the price.");
    }

    @Test
    void exactPayment() {
        int salePrice = 0;
        try {
            salePrice = testObj.scanItem(1, 10).getSalePrice();
        } catch (Exception e) {
            fail("Exception thrown when doing legitimate action");
        }
        int res = testObj.payment(salePrice);
        int expRes = 0;
        assertEquals(expRes, res, "Paying the exact amount gives wrong change.");
    }

    @Test
    void overPayment() {
        int salePrice = 0;
        try {
            salePrice = testObj.scanItem(1, 10).getSalePrice();
        } catch (Exception e) {
            fail("Exception thrown when doing legitimate action");
        }
        int expRes = 100;
        int res = testObj.payment(salePrice + expRes);
        assertEquals(expRes, res, "Overpaying gives wrong change.");
    }
}