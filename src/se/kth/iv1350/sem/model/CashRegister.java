package se.kth.iv1350.sem.model;

/**
 * Meant to represent a physical cash register that you store cash payments in
 * and take change out of.
 */
public class CashRegister {
    private int balance;

    /**
     * Creates an instance of <code>CashRegister</code> with balance set to 0.
     */
    public CashRegister() {
        this.balance = 0;
    }

    /**
     * Updates the balance with the received payment and calculates and returns
     * the change to give back to the customer.
     * @param salePrice Price for the sale tat the customer have to pay.
     * @param paymentAmount The amount paid by the customer.
     * @return Change The amount to give back to the customer.
     */
    public int updateBalance(int salePrice, int paymentAmount) {
        this.balance += salePrice;
        return paymentAmount - salePrice;
    }

}
