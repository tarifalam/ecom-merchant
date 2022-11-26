package com.ecom.merchant.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecom.merchant.product.Product;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer id;

    @NotEmpty
    private String name;

    public static Category convertToDomain(CategoryDto categoryDto){

        return Category.builder()
                .name(categoryDto.getName())
                .id(categoryDto.getId())
                .build();
    }

    public static CategoryDto convertToDto(Category category){
        return CategoryDto.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }

}
