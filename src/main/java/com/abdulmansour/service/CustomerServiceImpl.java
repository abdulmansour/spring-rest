package com.abdulmansour.service;

import com.abdulmansour.dao.CustomerDAO;
import com.abdulmansour.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDAO.saveCustomer(theCustomer);
    }

    @Transactional
    public Customer getCustomer(int theId) {

        return customerDAO.getCustomer(theId);
    }

    @Transactional
    public void deleteCustomer(int theId) {

        customerDAO.deleteCustomer(theId);
    }
}
