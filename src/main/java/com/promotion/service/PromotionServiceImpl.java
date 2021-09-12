package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;
import com.promotion.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
@Service
public class PromotionServiceImpl extends GenericServiceImpl<Promotion> implements PromotionService{
    private final PromotionRepository promotionRepository;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final EmailService emailService;

    @Value("${PromotionService.discountValue}")
    private String discountValue;

    PromotionServiceImpl(PromotionRepository promotionRepository, CustomerService customerService,
                         CustomerRepository customerRepository,EmailService emailService){
        this.promotionRepository = promotionRepository;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.emailService = emailService;
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
    public List<Customer> getCustomerByBirthdate(LocalDate date){
        return customerService.getCustomerByBirthday(date);
    }

    @Override
    public void sendMessageToCustomer(Customer customer){
        Promotion promotion = promotionRepository.getById(1L);
        String mensaje = promotion.getDescription();
        mensaje = mensaje.replace("<name>",customer.getName());
        mensaje = mensaje.replace("<discountValue>",discountValue);

        String to = customer.getEmail();
        String subject = "Prueba1";
        emailService.sendSimpleMessage(to,subject,mensaje);
    }
}
