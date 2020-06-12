package com.abdulmansour.rest;

import com.abdulmansour.entity.Customer;
import com.abdulmansour.exceptionhandling.CustomerNotFoundException;
import com.abdulmansour.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService to use DAO methods
    @Autowired
    private CustomerService customerService;

    //add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return customers;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        return customer;

    }

}
