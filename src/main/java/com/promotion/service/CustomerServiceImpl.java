package com.promotion.service;

import com.promotion.model.Customer;
import com.promotion.repository.CustomerRepository;
import com.promotion.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService{

    public final CustomerRepository repository;
    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Customer> getRepository() {
        return repository;
    }

    @Override
    public List<Customer> getCustomerByBirthday(LocalDate date){
        List<Customer> customerAll = repository.findAll();
        List<Customer> customerSelect = new ArrayList<>();
        String fechaActual = formatDateToString(date);
        for(Customer customer: customerAll){
            String birthday = formatDateToString(customer.getBirthday());
            if(birthday.equals(fechaActual)){
                customerSelect.add(customer);
            }
        }
        return customerSelect;
    }

    private String formatDateToString(LocalDate date){
        String format = date.format(DateTimeFormatter.ofPattern("MM/dd"));
        return format;
    }

}
