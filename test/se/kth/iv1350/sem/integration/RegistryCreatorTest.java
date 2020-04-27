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
    }

    @Test
    void getItemRegistry() {
    }

    @Test
    void getSaleRegistry() {
    }
}