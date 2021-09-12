package com.promotion.controller;

import com.promotion.dto.PromotionDto;
import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.service.GenericService;
import com.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PromotionController extends GenericController<Promotion, PromotionDto>{

    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }
    @Autowired
    protected GenericService getService() {
        return service;
    }

    @GetMapping("/promotion/{birthday}")
    public List<Customer> sendMessageToBirthday(@PathVariable("birthday") String fecha){
        LocalDate date = LocalDate.parse(fecha);
        List<Customer> customerList = service.getCustomerByBirthdate(date);
        for(Customer customer: customerList){
            service.sendMessageToCustomer(customer);
        }
        return customerList;
    }
}
