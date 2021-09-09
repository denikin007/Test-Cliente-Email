package com.promotion.model;

import com.promotion.dto.CustomerDto;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Customer extends ModelBase<CustomerDto>{

    @Column
    private String nombre;
    @Column
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
