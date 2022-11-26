package com.ecom.merchant.product.stock;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.ProductDto;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.combination.ProductCombinationDto;
import com.ecom.merchant.product.variant.option.ProductVariantOption;

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
