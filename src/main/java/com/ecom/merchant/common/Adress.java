package com.ecom.merchant.common;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
public class Adress {

    private String roadNo;

    private String houseNo;

    private String state;

    private String city;
}
