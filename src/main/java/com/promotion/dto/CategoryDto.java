package com.promotion.dto;


import com.promotion.exception.CheckedException;
import com.promotion.exception.UncheckedException;
import com.promotion.model.Category;

public class CategoryDto extends DtoBase<Category>{
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean validateChecked() throws CheckedException {
        if (getCode().length() < 5){
            throw new CheckedException();
        }else{
            return true;
        }
    }
    public boolean validateUnchecked(){
        if(getCode().length() < 5){
            throw new UncheckedException();
        }else{
            return true;
        }
    }
}
