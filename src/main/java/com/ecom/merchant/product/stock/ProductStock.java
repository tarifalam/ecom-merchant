package com.ecom.merchant.product.stock;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;

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
import java.util.Set;

/**
 * Created by Istiaq on 11/25/2022.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductStock  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String unitPrice;
  
  private String totalPrice;
  
  private String totalStock;

  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "product_combination_id", nullable = false)
  private ProductCombination productCombination; 




}
