/**
 * @author: Edson A. Terceros T.
 */

package com.promotion;

import com.promotion.model.Customer;
import com.promotion.model.Promotion;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.PromotionRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerRepository customerRepository;
    private PromotionRepository promotionRepository;
    @Value("${PromotionService.mensaje}")
    private String mensaje;

    public DevelopmentBootstrap(CustomerRepository customerRepository, PromotionRepository promotionRepository) {
        this.customerRepository = customerRepository;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("evento de spring");
        persistCustomer("Denikin", LocalDate.parse("2006-04-03"),"lofego4648@rebation.com");
        persistCustomer("Pablo", LocalDate.parse("2005-04-03"),"lofego4648@rebation.com");
        persistCustomer("Andres",LocalDate.parse("2004-09-12"),"lofego4648@rebation.com");
        persistCustomer("Maria",LocalDate.parse("2009-03-06"),"lofego4648@rebation.com");
        persistCustomer("Diana",LocalDate.parse("2000-05-15"),"lofego4648@rebation.com");
        persistCustomer("Carla",LocalDate.parse("2002-09-12"),"lofego4648@rebation.com");
        persistCustomer("Juan",LocalDate.parse("2006-01-01"),"lofego4648@rebation.com");
        persistPromotion(mensaje);
    }

    private void persistCustomer(String name, LocalDate birthday,String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBirthday(birthday);
        customer.setEmail(email);
        customerRepository.save(customer);
    }
    private void persistPromotion(String description){
        Promotion promotion = new Promotion();
        promotion.setDescription(description);
        promotionRepository.save(promotion);
    }
}
