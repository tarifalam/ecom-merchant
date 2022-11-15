package com.ecom.merchant.merchant.merchant;

import com.ecom.merchant.merchant.common.Adress;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

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
