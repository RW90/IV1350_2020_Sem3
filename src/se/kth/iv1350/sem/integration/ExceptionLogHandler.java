package se.kth.iv1350.sem.integration;

/**
 * Takes care of logging exceptions happening during runtime of the system.
 * Since there is no proper I/O, prints to sys.out.
 */
public class ExceptionLogHandler {

    /**
     * Dummy function meant to simulate logging errors but actually sending them to system.out.
     * @param e <code>Exception</code> meant to be logged.
     */
    public void logError(Throwable e){
        System.out.println("Log error: ");
        System.out.println(e);
    }
}
