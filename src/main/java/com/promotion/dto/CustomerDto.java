package com.promotion.dto;

import com.promotion.model.Customer;

import java.util.Date;

public class CustomerDto extends DtoBase<Customer>{
    private String nombre;
    private Date birthday;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
