package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;

import java.util.Date;
import java.util.List;

public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService{

    public final CustomerRepository repository;
    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Customer> getCustomerByBirthday(Date date){
        List<Customer> customerAll = repository.findAll();

        for(Customer customer: customerAll){
            Date Birthday = customer.getBirthday();
            System.out.println(customer);
        }
        return customerAll;
    }

    @Override
    protected GenericRepository<Customer> getRepository() {
        return repository;
    }
}
