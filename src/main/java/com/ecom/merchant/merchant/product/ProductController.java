package com.ecom.merchant.merchant.product;


import com.ecom.merchant.merchant.utility.ResponseObj;
import com.ecom.merchant.merchant.utility.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/product")
    public ResponseObj save(@RequestBody @Valid ProductDto productDto){
        ProductDto savedProduct = productService.save(productDto);
        return ResponseObj.builder().responseBody(savedProduct)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.CREATED)
                .message("Product Created Successfully")
                .build();
    }
}
