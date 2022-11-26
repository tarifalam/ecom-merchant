package com.ecom.merchant.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.merchant.utility.ResponseObj;
import com.ecom.merchant.utility.ReturnStatus;

import java.util.List;
import java.util.Set;

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
    @GetMapping(value = "/products")
    public ResponseObj getProduct(){
        Set<ProductDto> products = productService.getAll();
        return ResponseObj.builder().responseBody(products)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.ACCEPTED)
                .message("Product Information loaded Successfully.")
                .build();
    }
}
