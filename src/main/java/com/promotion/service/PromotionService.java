package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface PromotionService extends GenericService<Promotion>{

    Promotion save(Promotion promotion);

    List<Customer> getCustomerByBirthdate(LocalDate date);

    void sendMessageToCustomer(Customer customer);
}
