package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.PromotionRepository;
import com.promotion.service.GenericService;

import java.util.Date;
import java.util.List;

public class PromotionService{
    private final PromotionRepository promotionRepository;
    private final CustomerRepository customerRepository;

    PromotionService(PromotionRepository promotionRepository, CustomerRepository customerRepository){
        this.promotionRepository = promotionRepository;
        this.customerRepository = customerRepository;
    }

    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }
    public List<Customer> getCustomerByBirthdate(Date date){
        List<Customer> customerAll = customerRepository.getCustomerByBirthday(date);

        return null;
    }

    public void sendMessage(){

    }
}
