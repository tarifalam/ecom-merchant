package com.ecom.merchant.merchant.category;


import com.ecom.merchant.merchant.product.ProductDto;
import com.ecom.merchant.merchant.product.ProductService;
import com.ecom.merchant.merchant.utility.ResponseObj;
import com.ecom.merchant.merchant.utility.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/category")
    public ResponseObj save(@RequestBody @Valid CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.save(categoryDto);
        return ResponseObj.builder().responseBody(savedCategory)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.CREATED)
                .message("Category Created Successfully")
                .build();
    }
}
