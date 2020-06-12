package com.abdulmansour.service;

import com.abdulmansour.dao.CustomerDAO;
import com.abdulmansour.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    public void saveCustomer(Customer customer) {

    }

    public void deleteCustomer(int id) {

    }


}
