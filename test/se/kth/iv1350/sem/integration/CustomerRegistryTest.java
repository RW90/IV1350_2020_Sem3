package se.kth.iv1350.sem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem.model.DiscountDTO;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRegistryTest {
    CustomerRegistry testRegistry;
    @BeforeEach
    void setUp() {
        testRegistry = new CustomerRegistry();
    }

    @AfterEach
    void tearDown() {
        testRegistry = null;
    }

    @Test
    void fetchCustomerDiscount() {
        DiscountDTO discount = testRegistry.fetchCustomerDiscount("Anna");
        boolean result = discount instanceof DiscountDTO;
        boolean expRes = true;
        assertEquals(result, expRes, "Doesn't fetch valid customers discount.");
    }

    @Test
    void fetchCustomerNullDiscount() {
        DiscountDTO discount = testRegistry.fetchCustomerDiscount("Leif");
        boolean result = discount instanceof DiscountDTO;
        boolean expRes = false;
        assertEquals(result, expRes, "Fetches customers discount even though it's null.");
    }

    @Test
    void fetchInvalidCustomerDiscount() {
        DiscountDTO discount = testRegistry.fetchCustomerDiscount("Richard");
        boolean result = discount instanceof DiscountDTO;
        boolean expRes = false;
        assertEquals(result, expRes, "Fetches invalid customers discount.");
    }
}