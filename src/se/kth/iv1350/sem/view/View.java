package se.kth.iv1350.sem.view;

import se.kth.iv1350.sem.controller.Controller;
import se.kth.iv1350.sem.integration.DatabaseConnectionFailureException;
import se.kth.iv1350.sem.integration.InvalidItemIdException;

/**
 * Mock up of a view represented by this class. Contain hard-coded calls to the controller to
 * simulate UI interaction.
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorDisplay;

    /**
     * Instantiates the mock up view. Also initiates a test run of the program simulating ui inputs.
     * @param contr Controller of the system so the ui can interact with the business logic.
     */
    public View(Controller contr) {
        this.contr = contr;
        this.errorDisplay = new ErrorMessageHandler();
    }

    /**
     * Starting a simulation of the program
     */
    public void testRun(){
        System.out.println("Initializing test run...");
        System.out.println("Starting sale");
        contr.newSale();
        System.out.println("Adding 1 item id 1");
        try{
            System.out.println(contr.scanItem(1, 1));
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Adding invalid item");
        try{
            System.out.println(contr.scanItem(-1, 10));
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Simulating database failure");
        try{
            contr.scanItem(-10, 3);
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Adding 3 item id 2");
        try{
            System.out.println(contr.scanItem(2, 3));
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Adding 5 item id 3");
        try{
            System.out.println(contr.scanItem(3, 5));
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Adding 2 item id 1");
        try{
            System.out.println(contr.scanItem(1, 2));
        } catch (InvalidItemIdException e) {
            handleInvalidIdException(e);
        } catch (DatabaseConnectionFailureException e) {
            handleDatabaseFailureException(e);
        }
        System.out.println("Ending sale");
        System.out.println(contr.endSale());
        System.out.println("Requesting discount");
        System.out.println(contr.discountRequest("Anna"));
        System.out.println("Accepting payment of 500");
        System.out.println(contr.payment(500));

    }

    private void handleInvalidIdException(InvalidItemIdException e) {
        errorDisplay.displayError("Invalid item scanned of id: " + e.getItemId());
    }

    private void handleDatabaseFailureException(DatabaseConnectionFailureException e) {
        errorDisplay.displayError("Failure to connect to database. Try again.");
    }
}
