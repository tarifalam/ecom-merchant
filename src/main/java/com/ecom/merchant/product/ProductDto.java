package com.ecom.merchant.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.combination.ProductCombinationDto;
import com.ecom.merchant.product.stock.ProductStock;
import com.ecom.merchant.product.stock.ProductStockDto;
import com.ecom.merchant.product.variant.option.ProductVariantOption;
import com.ecom.merchant.product.variant.option.ProductVariantOptionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private String productName;

    private String productDescription;

    private String previewImage;

    private Integer categoryId;

    private String categoryName;

    @NotNull
    private BigDecimal price;

    private String desc;

    private String imagePath;    
     
    private Set<ProductCombinationDto> productCombination;
     
    private Set<ProductVariantOptionDto> productVariantOption;


    public static Product convertToDomain(ProductDto productDto){

        return Product.builder()
                .productName(productDto.getProductName())
                .productDescription(productDto.getProductDescription())
                .previewImage(productDto.getPreviewImage())
                .category(Category.builder().id(productDto.getCategoryId()).build())
                .build();
    }

    public static ProductDto convertToDto(Product product){
        return ProductDto.builder()
        		.productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .previewImage(product.getPreviewImage())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .build();
    }
    
    static Set<ProductDto> convertToListDto(Set<Product> products) {
        if (products == null || products.isEmpty()) {
            return Collections.emptySet();
        }
        
        return products.stream()
                .map(product -> 
                ProductDto.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productCombination(ProductCombinationDto.convertToListDto(product.getProductCombination()))
                .productVariantOption(ProductVariantOptionDto.convertToListDto(product.getProductVariantOption()))
                .build())
      .collect(Collectors.toSet());
    }
 

}
