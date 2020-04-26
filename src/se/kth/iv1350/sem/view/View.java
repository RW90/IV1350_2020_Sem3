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
    }
}
