package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;
import com.promotion.repository.PromotionRepository;

import java.util.Date;
import java.util.List;

public class PromotionServiceImpl extends GenericServiceImpl<Promotion> implements PromotionService{
    private final PromotionRepository promotionRepository;
    private final CustomerService customerService;

    PromotionServiceImpl(PromotionRepository promotionRepository, CustomerService customerService){
        this.promotionRepository = promotionRepository;
        this.customerService = customerService;
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
        List<Customer> customerAll = customerService.getCustomerByBirthday(date);

        return null;
    }

    @Override
    public void sendMessage(Long id){

    }
}
