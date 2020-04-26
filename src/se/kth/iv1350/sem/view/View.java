package se.kth.iv1350.sem.view;

import se.kth.iv1350.sem.controller.Controller;

/**
 * Mock up of a view represented by this class. Contain hard-coded calls to the controller to
 * simulate UI interaction.
 */
public class View {
    private Controller contr;

    /**
     * Instantiates the mock up view. Also initiates a test run of the program simulating ui inputs.
     * @param contr Controller of the system so the ui can interact with the business logic.
     */
    public View(Controller contr) {
        this.contr = contr;
        testRun();
    }

    private void testRun(){
        System.out.println("Initializing test run...");
        System.out.println("Starting sale");
        contr.newSale();
        System.out.println("Adding 1 item id 1");
        System.out.println(contr.scanItem(1, 1));
        System.out.println("Adding invalid item");
        System.out.println(contr.scanItem(-1, 10));
        System.out.println("Adding 3 item id 2");
        System.out.println(contr.scanItem(2, 3));
        System.out.println("Adding 5 item id 3");
        System.out.println(contr.scanItem(3, 5));
        System.out.println("Adding 2 item id 1");
        System.out.println(contr.scanItem(1, 2));
        System.out.println("Ending sale");
        System.out.println(contr.endSale());
        System.out.println("Requesting discount");
        System.out.println(contr.discountRequest("Anna"));
        System.out.println("Accepting payment of 500");
        System.out.println(contr.payment(500));

    }
}
