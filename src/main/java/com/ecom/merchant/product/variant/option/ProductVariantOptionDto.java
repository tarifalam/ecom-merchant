package com.ecom.merchant.product.variant.option;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.combination.ProductCombinationDto;
import com.ecom.merchant.product.stock.ProductStockDto;
import com.ecom.merchant.product.variant.optionvalue.ProductVariantOptionValue;
import com.ecom.merchant.product.variant.optionvalue.ProductVariantOptionValueDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  Created by Istiaq on 11/25/2022.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductVariantOptionDto  {
 
  private Integer id;

  private String variantName;  
   
  @ToString.Exclude
  private Product product; 
   
  private Set<ProductVariantOptionValueDto> productVariantOptionValue;


  public static Set<ProductVariantOptionDto> convertToListDto(Set<ProductVariantOption> productVariantOptions) {
      if (productVariantOptions == null || productVariantOptions.isEmpty()) {
          return Collections.emptySet();
      }
      
      return productVariantOptions.stream()
              .map(productVariantOption -> 
              ProductVariantOptionDto.builder()
        		.id(productVariantOption.getId())
        		.variantName(productVariantOption.getVariantName())               
                .productVariantOptionValue(ProductVariantOptionValueDto.convertToListDto(productVariantOption.getProductVariantOptionValue())).build()) 
    .collect(Collectors.toSet());
  }

}
