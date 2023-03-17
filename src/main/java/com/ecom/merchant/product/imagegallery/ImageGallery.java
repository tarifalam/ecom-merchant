package com.ecom.merchant.product.imagegallery;

import com.ecom.merchant.product.image.ProductImage;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
