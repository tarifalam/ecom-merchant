package com.ecom.merchant.product.stock;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 
public class ProductStockDto  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String unitPrice;
  
  private String totalPrice;
  
  private String totalStock;



  public static ProductStockDto convertToDto(ProductStock productStock){
      return ProductStockDto.builder()
      		.unitPrice(productStock.getUnitPrice())
              .totalPrice(productStock.getTotalPrice())
              .totalStock(productStock.getTotalStock())
              .build();
  }

  public static Set<ProductStockDto> convertToListDto(Set<ProductStock> productStocks) {
      if (productStocks == null || productStocks.isEmpty()) {
          return Collections.emptySet();
      }
      
      return productStocks.stream()
              .map(productStock -> 
              ProductStockDto.builder()
              .totalPrice(productStock.getTotalPrice())
              .totalStock(productStock.getTotalStock())
              .unitPrice(productStock.getUnitPrice())
              .build())
    .collect(Collectors.toSet());
      
  }
  
}
