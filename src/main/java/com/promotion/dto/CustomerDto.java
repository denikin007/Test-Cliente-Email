package com.promotion.dto;

import com.promotion.model.Customer;

import java.time.LocalDate;

public class CustomerDto extends DtoBase<Customer>{
    private String nombre;
    private LocalDate birthday;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
