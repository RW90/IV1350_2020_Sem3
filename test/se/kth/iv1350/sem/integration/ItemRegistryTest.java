package se.kth.iv1350.sem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem.model.ItemInfoDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegistryTest {
    ItemRegistry testRegistry;

    @BeforeEach
    void setUp() {
        testRegistry = new ItemRegistry();
    }

    @AfterEach
    void tearDown() {
        testRegistry = null;
    }

    @Test
    void fetchItem() {
        ItemInfoDTO testItem = null;
        try {
            testItem = testRegistry.fetchItem(1);
        } catch(Exception e) {
            fail("Exception thrown when fetching valid item.");
        }
        boolean res = testItem instanceof ItemInfoDTO;
        boolean expRes = true;
        assertEquals(res, expRes, "Unable to fetch valid item.");
    }

    @Test
    void fetchInvalidItem() {
        ItemInfoDTO testItem = null;
        try {
            testItem = testRegistry.fetchItem(-1);
            fail("Exception not thrown when fetching invalid item.");
        } catch(Exception e) {
            boolean res = e instanceof InvalidItemIdException;
            assertTrue(res, "Wrong exception thrown when fetching invalid item.");
        }
    }

    @Test
    void databaseConnectionFailure() {
        ItemInfoDTO testItem = null;
        try {
            testItem = testRegistry.fetchItem(-10);
            fail("Exception not thrown when simulating database connection failure.");
        } catch(Exception e) {
            boolean res = e instanceof DatabaseConnectionFailureException;
            assertTrue(res, "Wrong exception thrown when simulating database connection failure.");
        }
    }
}