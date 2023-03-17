package com.ecom.merchant.product.variant.option;

import com.ecom.merchant.product.image.ProductImageDto;
import com.ecom.merchant.product.variant.ProductVariantDto;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Istiaq on 11/25/2022.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VariantOptionDto {


    private Integer id;

    private String optionName;

    private String sku;

    private BigDecimal price;

    @ToString.Exclude
    private ProductVariantDto productVariantOption;

    private Set<ProductImageDto> productImage;


    public static VariantOption convertToDomain(VariantOptionDto variantOptionDto){
        return VariantOption.builder()
                .id(variantOptionDto.getId())
                .optionName(variantOptionDto.optionName)
                .sku(variantOptionDto.sku)
                .price(variantOptionDto.price)
                .build();
    }

    public static VariantOptionDto convertToDto(VariantOption variantOption){
        return VariantOptionDto.builder()
                .id(variantOption.getId())
                .optionName(variantOption.getOptionName())
                .sku(variantOption.getSku())
                .price(variantOption.getPrice())
                .build();
    }

    public static Set<VariantOption> convertToDomainList(Set<VariantOptionDto> variantOptionDtos){
        return variantOptionDtos.stream()
                .map(variantOptionDto -> convertToDomain(variantOptionDto))
                .collect(Collectors.toSet());
    }

    public static Set<VariantOptionDto> convertToDtoList(Set<VariantOption> variantOptions){
        return variantOptions.stream()
                .map(variantOption -> convertToDto(variantOption))
                .collect(Collectors.toSet());
    }



}
