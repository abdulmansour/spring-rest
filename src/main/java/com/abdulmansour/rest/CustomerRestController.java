package com.abdulmansour.rest;

import com.abdulmansour.entity.Customer;
import com.abdulmansour.exceptionhandling.CustomerNotFoundException;
import com.abdulmansour.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService to use DAO methods
    @Autowired
    private CustomerService customerService;

    //add mapping for GET /customers to fetch customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return customers;
    }

    //add mapping for GET /customers/{customerId} to fetch unique customer
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        return customer;
    }

    //add mapping for POST /customers to add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        // when the dao process a customer with id 0, it will interpret as null and will INSERT a new customer in db with unique id
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

}
