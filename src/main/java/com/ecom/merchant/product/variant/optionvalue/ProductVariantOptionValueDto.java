package com.ecom.merchant.product.variant.optionvalue;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.image.ProductImage;
import com.ecom.merchant.product.image.ProductImageDto;
import com.ecom.merchant.product.stock.ProductStock;
import com.ecom.merchant.product.stock.ProductStockDto;
import com.ecom.merchant.product.variant.option.ProductVariantOption;
import com.ecom.merchant.product.variant.option.ProductVariantOptionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
 * Created by Istiaq on 11/25/2022.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductVariantOptionValueDto  {

 
  private Integer id;

  private String optionValue;
 
  @ToString.Exclude
  private ProductVariantOptionDto productVariantOption; 

  private Set<ProductImageDto> productImage;

  public static Set<ProductVariantOptionValueDto> convertToListDto(Set<ProductVariantOptionValue> productVariantOptionValues) {
      if (productVariantOptionValues == null || productVariantOptionValues.isEmpty()) {
          return Collections.emptySet();
      }
      
      return productVariantOptionValues.stream()
              .map(productVariantOptionValue -> 
              ProductVariantOptionValueDto.builder()
              .optionValue(productVariantOptionValue.getOptionValue())
              .id(productVariantOptionValue.getId())
              .build())
    .collect(Collectors.toSet());
      
  }

}
