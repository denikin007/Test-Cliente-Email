package com.promotion.controller;

import com.promotion.dto.PromotionDto;
import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.service.GenericService;
import com.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/promotion")
public class PromotionController extends GenericController<Promotion, PromotionDto>{

    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }
    @Autowired
    protected GenericService getService() {
        return service;
    }

    @GetMapping(value = "/promotion/birthday/{idPromotion}")
    public void getBirthday(@PathVariable("idPromotion") Long idPromotion) {
        service.sendMessage(idPromotion);
    }

    @GetMapping("/prueba")
    public List<Customer> hola(){
        return service.getCustomerByBirthdate(new Date());
    }
}
