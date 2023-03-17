package com.ecom.merchant.product.variant.option;

import com.ecom.merchant.product.image.ProductImage;
import com.ecom.merchant.product.variant.ProductVariant;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Istiaq on 11/25/2022.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VariantOption  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String optionName;

  private String sku;

  private BigDecimal price;

   
//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
//  @JoinColumn(name = "product_variant_id", nullable = false)
//  @ToString.Exclude
//  private ProductVariant productVariantOption;


  @OneToMany(mappedBy = "productVariantOptionValue", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<ProductImage> productImage;



}
