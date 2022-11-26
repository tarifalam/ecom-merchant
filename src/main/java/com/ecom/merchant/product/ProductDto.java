package com.ecom.merchant.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecom.merchant.category.Category;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
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


    public static Product convertToDomain(ProductDto productDto){

    	return null;
    			
//        return Product.builder()
//                .productName(productDto.getProductName())
//                .productDescription(productDto.getProductDescription())
//                .previewImage(productDto.getPreviewImage())
//                .category(Category.builder().id(productDto.getCategoryId()).build())
//                .build();
    }

    public static ProductDto convertToDto(Product product){
        return null;
//    	return ProductDto.builder()
//        		.productName(product.getProductName())
//                .productDescription(product.getProductDescription())
//                .previewImage(product.getPreviewImage())
//                .categoryId(product.getCategory().getId())
//                .categoryName(product.getCategory().getName())
//                .build();
    }
    
    static List<ProductDto> convertToListDto(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return Collections.emptyList();
        }
        
        return products.stream()
                .map(product -> 
                ProductDto.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .build())
      .collect(Collectors.toList());
    }

}
