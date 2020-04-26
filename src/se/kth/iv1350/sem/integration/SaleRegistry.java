package se.kth.iv1350.sem.integration;

import se.kth.iv1350.sem.model.SaleLogDTO;
import java.util.ArrayList;

/**
 * Class meant to communicate with external accounting system.
 * Implemented as a mock up as specified in seminar instructions.
 */
public class SaleRegistry {
    ArrayList<SaleLogDTO> loggedSales;

    SaleRegistry() {
        loggedSales = new ArrayList<SaleLogDTO>();
    }

    /**
     * Logs information about a sale given as a <code>SaleLogDTO</code> object to the
     * mock database.
     * @param saleToLog Sale occasion to log.
     */
    public void logSale(SaleLogDTO saleToLog) {
        loggedSales.add(saleToLog);
    }
}
