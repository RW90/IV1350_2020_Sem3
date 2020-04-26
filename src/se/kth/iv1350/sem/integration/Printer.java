package se.kth.iv1350.sem.integration;

import se.kth.iv1350.sem.model.SaleLogDTO;

/**
 * Class meant to communicate with the external system who prints the receipt.
 * Implemented as a mock up as per seminar specifications.
 */
public class Printer {

    /**
     * Creates an instance of an external systems arbiter communicating with
     * a printer who prints receipts.
     */
    public Printer() {

    }

    /**
     * Mock up function meant to represent a function that sends sale data
     * to an external printer to print a receipt.
     * @param saleData Data to print on the receipt.
     */
    public void printReceipt(SaleLogDTO saleData) {
        System.out.println("Printing receipt...");
    }
}
