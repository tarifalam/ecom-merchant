package com.ecom.merchant.product;

import com.ecom.merchant.brand.Brand;
import com.ecom.merchant.category.CategoryDto;
import com.ecom.merchant.product.variant.ProductVariantDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collections;
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


    private String imagePath;    
    
    private CategoryDto category;
    
    private Brand brand;
     
    //private Set<ProductCombinationDto> productCombination;
     
    private Set<ProductVariantDto> productVariants;


    public static Product convertToDomain(ProductDto productDto){

        return Product.builder()
                .productName(productDto.productName)
                .productDescription(productDto.productDescription)
                .previewImage(productDto.getPreviewImage())
                .productVariants(ProductVariantDto.convertToDomainList(productDto.getProductVariants()))
                .category(CategoryDto.convertToDomain(productDto.category))
                .build();
    }


    public static ProductDto convertToDto(Product product){
        return ProductDto.builder()
        		.productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .previewImage(product.getPreviewImage())
                .category(CategoryDto.convertToDto(product.getCategory()))
                .brand(product.getBrand())
                //.productCombination(ProductCombinationDto.convertToListDto(product.getProductCombination()))
                .productVariants(ProductVariantDto.convertToDtoList(product.getProductVariants()))
                .build();
    }
    
    public static Set<ProductDto> convertToListDto(Set<Product> products) {
        if (products == null || products.isEmpty()) {
            return Collections.emptySet();
        }
        return products.stream()
                .map(product -> convertToDto(product))
                .collect(Collectors.toSet());
    }
 

}
