package com.promotion.service;

import com.promotion.model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService extends GenericService<Customer>{
    List<Customer> getCustomerByBirthday(LocalDate date);
}
