package com.promotion;


import com.promotion.dto.CategoryDto;
import com.promotion.exception.CheckedException;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.*;

@SpringBootTest
public class CategoryUnitTest {

    @Test
    public void givenCategoryDTOWithCodeLengthLessThanMinimunSizeWhenCategoryDTO(){
        CategoryDto categoryDto = new CategoryDto();
        boolean sanitizado = false;
        categoryDto.setCode("ABC");
        try{
            categoryDto.validateChecked();
        }catch(CheckedException e){
            categoryDto.setCode("XX"+ categoryDto.getCode());
            try{
                categoryDto.validateChecked();
                sanitizado=true;
            }catch(CheckedException ee){
                ee.printStackTrace(System.out);
            }
        }
        assertEquals(sanitizado,true);
        assertEquals(categoryDto.getCode(),"XXABC");
    }

    @Test
    public void validateCategoryDTO_validateUncheckedThenUncheckedErrorShouldBeThrown(){
        assertThrows(RuntimeException.class, () -> {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCode("ABC");
            boolean resultadoObtenido = categoryDto.validateUnchecked();
            assertEquals(resultadoObtenido,false);
        });

    }

    @Test
    public void validateCheckedThenCheckedErrorShouldBeThrown(){
        assertThrows(Exception.class, () -> {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCode("ABC");
            boolean resultadoObtenido = false;
            resultadoObtenido = categoryDto.validateChecked();
            assertEquals(resultadoObtenido,false);
        });
    }
}
