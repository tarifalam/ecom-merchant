package com.ecom.merchant.brand;

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
public class BrandDto {

    private Integer id;

    @NotEmpty
    private String name;

    public static Brand convertToDomain(BrandDto categoryDto){

        return Brand.builder()
                .name(categoryDto.getName())
                .id(categoryDto.getId())
                .build();
    }

    public static BrandDto convertToDto(Brand category){
        return BrandDto.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }

}
