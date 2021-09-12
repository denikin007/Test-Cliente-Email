/**
 * @author: Edson A. Terceros T.
 */

package com.promotion;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerRepository customerRepository;

    // injeccion evita hacer instancia   = new Clase();
    // bean pueden tener muchos campos y otros beans asociados

    public DevelopmentBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("evento de spring");
        /*   duplicacion de codigo
        Buy buy = new Buy();
        buy.setValue(BigDecimal.TEN);
        buyRespository.save(buy);
        Buy buy2 = new Buy();
        buy2.setValue(BigDecimal.ONE);
        buyRespository.save(buy);*/

        persistCustomer("Denikin",new Date());
        persistCustomer("Santos",new Date());
    }

    private void persistCustomer(String nombre, Date birthday) {
        Customer customer = new Customer();
        customer.setNombre(nombre);
        customer.setBirthday(birthday);
        customerRepository.save(customer);
    }
}
