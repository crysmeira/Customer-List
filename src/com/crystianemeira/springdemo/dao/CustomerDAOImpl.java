package com.crystianemeira.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crystianemeira.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName asc", Customer.class);
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        
        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save / update the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query with the id
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        
        theQuery.executeUpdate();
    }

}