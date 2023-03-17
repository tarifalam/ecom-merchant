package com.ecom.merchant.product.combination;

import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.stock.ProductStockDto;
import lombok.*;

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
              .id(productCombination.getId())
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
                .id(productCombination.getId())
                .productCode(productCombination.getProductCode())
                .productStock(ProductStockDto.convertToListDto(productCombination.getProductStock())).build()) 
    .collect(Collectors.toSet());
  }


  

}
