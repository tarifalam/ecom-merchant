package com.ecom.merchant.product.combination;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.stock.ProductStock;
import com.ecom.merchant.product.variant.option.ProductVariantOption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Istiaq on 11/25/2022.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCombination  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String combinationString;
  
  private String sku;
  
  private String productCode;

  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "productId", nullable = false)
  private Product product; 
  
  @OneToMany(mappedBy = "productCombination", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductStock> productStock;



}
