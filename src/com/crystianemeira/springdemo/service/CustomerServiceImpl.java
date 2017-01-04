package com.crystianemeira.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crystianemeira.springdemo.dao.CustomerDAO;
import com.crystianemeira.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer DAO
    @Autowired
    private CustomerDAO customerDAO;
    
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

}
