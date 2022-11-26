package com.ecom.merchant.merchant;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import com.ecom.merchant.common.Adress;

@Entity
@Builder
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String contactNo;

    @Embedded
    private Adress adress;


}
