package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService{

    public final CustomerRepository repository;
    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Customer> getCustomerByBirthday(Date date){
        List<Customer> customerAll = repository.findAll();
        System.out.println(customerAll);
//        for(Customer customer: customerAll){
//            Date Birthday = customer.getBirthday();
//            System.out.println(customer);
//        }
        return customerAll;
    }

    @Override
    protected GenericRepository<Customer> getRepository() {
        return repository;
    }
}
