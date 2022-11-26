package com.ecom.merchant.product;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String currencyName;
    private String currencySymbol;
}
