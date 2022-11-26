package com.ecom.merchant.product;

import com.ecom.merchant.category.Category;
import com.ecom.merchant.merchant.Merchant;
import com.ecom.merchant.product.combination.ProductCombination;
import com.ecom.merchant.product.variant.option.ProductVariantOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
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
 * Created by Divineit-Iftekher on 1/16/2018.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
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
  
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JsonIgnore  
  private Set<ProductCombination> productCombination;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<ProductVariantOption> productVariantOption;

 

}
