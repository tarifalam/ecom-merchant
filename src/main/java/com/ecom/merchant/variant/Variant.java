package com.ecom.merchant.variant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.variant.option.ProductVariantOption;


/**
 *  Created by Istiaq on 11/25/2022.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Variant  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String variantName;

  @ManyToOne(optional = true)
  private Variant variant;

}
