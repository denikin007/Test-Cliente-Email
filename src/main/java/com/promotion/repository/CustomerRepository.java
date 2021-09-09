package com.promotion.repository;

import com.promotion.model.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends GenericRepository<Customer>{
    default List<Customer> getCustomerByBirthday(Date date){
        List<Customer> customerAll = findAll();

        for(Customer customer: customerAll){
            Date Birthday = customer.getBirthday();
            System.out.println(customer);
        }
        return customerAll;
    }
}
