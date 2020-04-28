package se.kth.iv1350.sem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    CashRegister testObj;
    @BeforeEach
    void setUp() {
        testObj = new CashRegister();
    }

    @AfterEach
    void tearDown() {
        testObj = null;
    }

    @Test
    void checkPositiveChangeCalculation() {
        int change = testObj.updateBalance(300, 400);
        int expRes = 400 - 300;
        assertEquals(change, expRes, "Nonzero positive change is not calculated properly.");
    }

    @Test
    void checkZeroChangeCalculation() {
        int change = testObj.updateBalance(300, 300);
        int expRes = 0;
        assertEquals(change, expRes, "Change of 0 is not calculated properly.");
    }

    @Test
    void checkNegativeChangeCalculation() {
        int change = testObj.updateBalance(300, 200);
        int expRes = 200-300;
        assertEquals(change, expRes, "Nonzero negative change is not calculated properly.");
    }
}