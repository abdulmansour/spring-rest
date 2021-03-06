package com.abdulmansour.dao;

import java.util.List;

import com.abdulmansour.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query; sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query deleteCustomerQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        deleteCustomerQuery.setParameter("customerId", id);

        deleteCustomerQuery.executeUpdate();
    }

}











