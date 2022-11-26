package com.ecom.merchant.product.variant.option;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.variant.optionvalue.ProductVariantOptionValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

/**
 *  Created by Istiaq on 11/25/2022.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductVariantOption  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String variantName;

  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "productId", nullable = false)
  private Product product; 
  
  @OneToMany(mappedBy = "productVariantOption", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductVariantOptionValue> productVariantOptionValue;



}
