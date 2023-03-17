package com.ecom.merchant.product.variant;

import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.variant.option.VariantOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 *  Created by Istiaq on 11/25/2022.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductVariant  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String variantName;

  private String variantType;

  
//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "product_id", nullable = false)
//  @ToString.Exclude
//  private Product product;


  @OneToMany(targetEntity = VariantOption.class, fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  @JoinColumn(name = "product_variant_id",referencedColumnName = "id")
  private Set<VariantOption> variantOptions;



}
