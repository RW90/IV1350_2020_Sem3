package se.kth.iv1350.sem.integration;

import se.kth.iv1350.sem.model.CustomerDTO;
import se.kth.iv1350.sem.model.DiscountDTO;

import java.util.ArrayList;

/**
 * Class meant to communicate with the customer database. Not fully
 * implemented, as it's not part of the scope of the seminar task.
 */
public class CustomerRegistry {
    private ArrayList<CustomerDTO> customers;

    CustomerRegistry() {
        customers = new ArrayList<CustomerDTO>();
        generateCustomers();
    }

    private void generateCustomers() {
        DiscountDTO customerDiscount = new DiscountDTO(0.8f);
        CustomerDTO customerToAdd = new CustomerDTO("Anna", customerDiscount);
        CustomerDTO customerToAdd2 = new CustomerDTO("Leif", null);
        customers.add(customerToAdd);
        customers.add(customerToAdd2);
    }

    /**
     * Searches the mock customer database for the customer with id given as parameter.
     * Returns the customers discount as a <code>DiscountDTO</code> if discountwas found, else returns <code>null</code>.
     * @param customerId Customer to search for.
     * @return <code>DiscountDTO</code> if customer has one, else returns <code>null</code>.
     */
    public DiscountDTO fetchCustomerDiscount(String customerId) {
        DiscountDTO returnDiscount = null;
        for(CustomerDTO customerInDB : customers) {
            if(customerInDB.getId().equals(customerId)) {
                returnDiscount = customerInDB.getDiscount();
                break;
            }
        }
        return returnDiscount;
    }
}
