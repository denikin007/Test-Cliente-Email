package com.promotion.service;

import com.promotion.model.Promotion;
import com.promotion.repository.PromotionRepository;
import com.promotion.service.GenericService;

public class PromotionService{
    private final PromotionRepository repository;
    PromotionService(PromotionRepository repository){
        this.repository = repository;
    }
    public Promotion save(Promotion promotion){
        return repository.save(promotion);
    }
}
