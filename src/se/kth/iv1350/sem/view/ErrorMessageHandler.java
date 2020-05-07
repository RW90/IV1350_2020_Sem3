package se.kth.iv1350.sem.view;

/**
 * Handles displaying exceptions to the UI.
 */
public class ErrorMessageHandler {

    /**
     * Dummy function meant to display an error in some way to the UI. Writes to System.out.
     * @param msg Error message to display.
     */
    public void displayError(String msg){
        System.out.println("Displaying error: ");
        System.out.println("ERROR: " + msg);
    }
}
