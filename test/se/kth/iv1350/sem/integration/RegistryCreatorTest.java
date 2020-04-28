package se.kth.iv1350.sem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistryCreatorTest {

    RegistryCreator registryCreator;
    @BeforeEach
    void setUp() {
        registryCreator = new RegistryCreator();
    }

    @AfterEach
    void tearDown() {
        registryCreator = null;
    }

    @Test
    void getCustomerRegistry() {
        CustomerRegistry customerRegistry = registryCreator.getCustomerRegistry();
        boolean res = customerRegistry instanceof CustomerRegistry;
        boolean expRes = true;
        assertEquals(res, expRes, "Customer registry unable to be created.");
    }

    @Test
    void getItemRegistry() {
        ItemRegistry itemRegistry = registryCreator.getItemRegistry();
        boolean res = itemRegistry instanceof ItemRegistry;
        boolean expRes = true;
        assertEquals(res, expRes, "Item registry unable to be created.");
    }

    @Test
    void getSaleRegistry() {
        SaleRegistry saleRegistry = registryCreator.getSaleRegistry();
        boolean res = saleRegistry instanceof SaleRegistry;
        boolean expRes = true;
        assertEquals(res, expRes, "Sale registry unable to be created.");
    }
}