package com.ecom.merchant.product.image;

import com.ecom.merchant.product.imagegallery.ImageGallery;
import com.ecom.merchant.product.variant.option.VariantOptionDto;
import lombok.*;

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

  private VariantOptionDto productVariantOptionValue;

}
