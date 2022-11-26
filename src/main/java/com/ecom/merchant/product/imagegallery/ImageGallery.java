package com.ecom.merchant.product.imagegallery;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.image.ProductImage;
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
public class ImageGallery  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String small;
  
  private String medium;
  
  private String large;


  @OneToMany(mappedBy = "imageGallery", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductImage> productImage;

}
