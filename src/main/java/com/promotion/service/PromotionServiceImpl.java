package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;
import com.promotion.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PromotionServiceImpl extends GenericServiceImpl<Promotion> implements PromotionService{
    private final PromotionRepository promotionRepository;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    PromotionServiceImpl(PromotionRepository promotionRepository, CustomerService customerService,CustomerRepository customerRepository){
        this.promotionRepository = promotionRepository;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @Override
    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }

    @Override
    protected GenericRepository<Promotion> getRepository() {
        return promotionRepository;
    }

    @Override
    public List<Customer> getCustomerByBirthdate(Date date){
        List<Customer> customerAll;
        return customerService.getCustomerByBirthday(date);
    }

    @Override
    public void sendMessage(Long id){

    }
}
