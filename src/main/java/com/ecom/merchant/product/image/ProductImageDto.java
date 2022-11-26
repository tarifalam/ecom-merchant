package com.ecom.merchant.product.image;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.imagegallery.ImageGallery;
import com.ecom.merchant.product.variant.option.ProductVariantOption;
import com.ecom.merchant.product.variant.optionvalue.ProductVariantOptionValue;
import com.ecom.merchant.product.variant.optionvalue.ProductVariantOptionValueDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ProductImageDto  {

  private Integer id;
  
  private Boolean isFeature;  

  private ImageGallery imageGallery; 

  private ProductVariantOptionValueDto productVariantOptionValue; 

}
