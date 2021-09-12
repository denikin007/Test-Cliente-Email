package com.promotion.dto;

import com.promotion.model.Customer;

import java.time.LocalDate;

public class CustomerDto extends DtoBase<Customer>{
    private String name;
    private LocalDate birthday;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
