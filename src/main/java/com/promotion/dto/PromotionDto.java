package com.promotion.dto;

import com.promotion.model.Promotion;

public class PromotionDto extends DtoBase<Promotion>{
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
