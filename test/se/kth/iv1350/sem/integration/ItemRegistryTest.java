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
        ItemInfoDTO testItem = testRegistry.fetchItem(1);
        boolean res = testItem instanceof ItemInfoDTO;
        boolean expRes = true;
        assertEquals(res, expRes, "Unable to fetch valid item.");
    }

    @Test
    void fetchInvalidItem() {
        ItemInfoDTO testItem = testRegistry.fetchItem(-1);
        boolean res = testItem instanceof ItemInfoDTO;
        boolean expRes = false;
        assertEquals(res, expRes, "Able to fetch invalid item.");
    }
}