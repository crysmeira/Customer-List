package com.crystianemeira.springdemo.service;

import java.util.List;

import com.crystianemeira.springdemo.entity.Customer;

public interface CustomerService {
    
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
