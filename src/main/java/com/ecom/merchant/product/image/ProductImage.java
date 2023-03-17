package com.ecom.merchant.product.image;

import com.ecom.merchant.product.imagegallery.ImageGallery;
import com.ecom.merchant.product.variant.option.VariantOption;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Istiaq on 11/25/2022.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ProductImage  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  private Boolean isFeature;

  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "image_gallery_id", nullable = false)
  private ImageGallery imageGallery; 


  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "product_variant_option_value_id", nullable = false)
  private VariantOption productVariantOptionValue;

}
