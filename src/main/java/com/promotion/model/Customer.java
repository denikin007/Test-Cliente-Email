package com.promotion.model;

import com.promotion.dto.CustomerDto;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
public class Customer extends ModelBase<CustomerDto>{

    @Column
    private String nombre;
    @Column
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
