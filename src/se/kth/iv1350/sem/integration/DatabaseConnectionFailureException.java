package se.kth.iv1350.sem.integration;

/**
 * Thrown when connection to database fails in the integration layer.
 */
public class DatabaseConnectionFailureException extends RuntimeException {

    /**
     * Creates a new instance of the exception to be thrown when failing to connect to database.
     * @param msg Message about what failed for the error logs.
     */
    public DatabaseConnectionFailureException(String msg) {
        super(msg);
    }
}