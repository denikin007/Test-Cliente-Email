package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.PromotionRepository;
import com.promotion.service.GenericService;

import java.util.Date;
import java.util.List;

public interface PromotionService extends GenericService<Promotion>{

    Promotion save(Promotion promotion);

    List<Customer> getCustomerByBirthdate(Date date);

    void sendMessage(Long id);
}
