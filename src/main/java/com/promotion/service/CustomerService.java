package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;

import java.util.Date;
import java.util.List;

public interface CustomerService extends GenericService<Customer>{
    List<Customer> getCustomerByBirthday(Date date);
}
