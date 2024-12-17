package org.otopark.service;

import org.otopark.dao.CustomerDao;
import org.otopark.model.Customer;

import java.sql.SQLException;

public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService() throws SQLException {

        customerDao = new CustomerDao();
    }

    public boolean createCustomer (Customer customer){
        return customerDao.createCustomer(customer);
    }
}
