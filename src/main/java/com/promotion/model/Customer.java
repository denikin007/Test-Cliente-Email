package com.promotion.model;

import com.promotion.dto.CustomerDto;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Customer extends ModelBase<CustomerDto>{

    @Column
    private String name;
    @Column
    private LocalDate birthday;
    @Column
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
