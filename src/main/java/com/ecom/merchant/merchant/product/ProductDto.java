package com.ecom.merchant.merchant.product;

import com.ecom.merchant.merchant.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String code;

    @NotEmpty
    private String name;

    private Integer categoryId;

    private String categoryName;

    @NotNull
    private BigDecimal price;

    private String desc;

    private String imagePath;


    public static Product convertToDomain(ProductDto productDto){

        return Product.builder()
                .code(productDto.getCode())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .category(Category.builder().id(productDto.getCategoryId()).build())
                .imagePath(productDto.getImagePath())
                .build();
    }

    public static ProductDto convertToDto(Product product){
        return ProductDto.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .imagePath(product.getImagePath())
                .build();
    }

}
