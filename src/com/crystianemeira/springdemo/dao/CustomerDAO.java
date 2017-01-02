package com.crystianemeira.springdemo.dao;

import java.util.List;

import com.crystianemeira.springdemo.entity.Customer;

public interface CustomerDAO {
    
    public List<Customer> getCustomers();
}
