package com.ecom.merchant.merchant.product;

import com.ecom.merchant.merchant.category.Category;
import com.ecom.merchant.merchant.merchant.Merchant;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * Created by Divineit-Iftekher on 1/16/2018.
 */
@Entity
@Builder
@Data
public class Product  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String code;

  private String name;

  private BigDecimal price;

  private String description;

  private String imagePath;

  @ManyToOne(optional = true)
  private Category category;

  @ManyToOne(optional = true)
  private Merchant merchant;



}
