package com.ecom.merchant.product;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.combination.ProductCombination;
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
 * Created by Divineit-Iftekher on 1/16/2018.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String productName;

  private String productDescription;

  private String previewImage;

  @ManyToOne(optional = true)
  private Category category;
  
  @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductCombination> productCombination;

  @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductVariantOption> productVariantOption;

 

}
