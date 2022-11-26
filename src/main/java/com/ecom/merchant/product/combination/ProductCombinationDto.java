package com.ecom.merchant.product.combination;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.ProductDto;
import com.ecom.merchant.product.stock.ProductStock;
import com.ecom.merchant.product.stock.ProductStockDto;
import com.ecom.merchant.product.variant.option.ProductVariantOption;
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
import java.util.List;
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
public class ProductCombinationDto  {

  
  private Integer id;

  private String combinationString;
  
  private String sku;
  
  private String productCode;
  
  @ToString.Exclude
  private Product product;
 
  @ToString.Exclude
  private Set<ProductStockDto> productStock;


  public static ProductCombinationDto convertToDto(ProductCombination productCombination){
      return ProductCombinationDto.builder()
      		.combinationString(productCombination.getCombinationString())
              .sku(productCombination.getSku())
              .productCode(productCombination.getProductCode())
              .productStock(ProductStockDto.convertToListDto(productCombination.getProductStock())).build();
  }
  
  public static Set<ProductCombinationDto> convertToListDto(Set<ProductCombination> productCombinations) {
      if (productCombinations == null || productCombinations.isEmpty()) {
          return Collections.emptySet();
      }
      
      return productCombinations.stream()
              .map(productCombination -> 
              ProductCombinationDto.builder()
        		.combinationString(productCombination.getCombinationString())
                .sku(productCombination.getSku())
                .productCode(productCombination.getProductCode())
                .productStock(ProductStockDto.convertToListDto(productCombination.getProductStock())).build()) 
    .collect(Collectors.toSet());
  }


  

}
