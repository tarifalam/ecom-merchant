package com.ecom.merchant.product.variant;

import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.variant.option.VariantOptionDto;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Istiaq on 11/25/2022.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductVariantDto {

    private Integer id;

    private String variantName;
    private String variantType;


//    @ToString.Exclude
//    private Product product;

    private Set<VariantOptionDto> variantOptions;


    public static ProductVariant convertToDomain(ProductVariantDto productVariantDto){
        return ProductVariant.builder()
                .id(productVariantDto.getId())
                .variantName(productVariantDto.getVariantName())
                .variantType(productVariantDto.variantType)
                .variantOptions(VariantOptionDto.convertToDomainList(productVariantDto.variantOptions))
                .build();
    }

    public static ProductVariantDto convertToDto(ProductVariant productVariant){
        return ProductVariantDto.builder()
                .id(productVariant.getId())
                .variantName(productVariant.getVariantName())
                .variantType(productVariant.getVariantType())
                .variantOptions(VariantOptionDto.convertToDtoList(productVariant.getVariantOptions()))
                .build();
    }


    public static Set<ProductVariant> convertToDomainList(Set<ProductVariantDto> productVariantDtos){
        return productVariantDtos.stream()
                .map(variantOptionDto -> convertToDomain(variantOptionDto))
                .collect(Collectors.toSet());
    }


    public static Set<ProductVariantDto> convertToDtoList(Set<ProductVariant> productVariants) {
        if (CollectionUtils.isEmpty(productVariants)) {
            return Collections.emptySet();
        }

        return productVariants.stream()
                .map(productVariant -> convertToDto(productVariant))
                .collect(Collectors.toSet());
    }

}
