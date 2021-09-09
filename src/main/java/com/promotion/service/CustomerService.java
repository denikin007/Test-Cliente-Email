package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;

public class CustomerService{
    public final CustomerRepository repository;
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }
}
