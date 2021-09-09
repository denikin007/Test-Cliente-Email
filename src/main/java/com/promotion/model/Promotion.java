package com.promotion.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Promotion extends ModelBase{
    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
