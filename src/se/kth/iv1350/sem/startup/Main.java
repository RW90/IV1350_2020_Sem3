package se.kth.iv1350.sem.startup;

import se.kth.iv1350.sem.controller.Controller;
import se.kth.iv1350.sem.integration.Printer;
import se.kth.iv1350.sem.integration.RegistryCreator;
import se.kth.iv1350.sem.model.StoreDTO;
import se.kth.iv1350.sem.view.View;

/**
 * Class containing main method that initializes the system.
 */
public class Main {

    /**
     * Main method of the program, where execution starts.
     * @param args Not used for anything.
     */
    public static void main(String[] args) {
        RegistryCreator registries = new RegistryCreator();
        Printer printer = new Printer();
        StoreDTO storeInfo = new StoreDTO("Bakgatan 1, KISTA", "Richards mathandel");
        Controller contr = new Controller(registries, printer, storeInfo);
        new View(contr);
    }
}
