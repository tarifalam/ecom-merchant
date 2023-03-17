package com.ecom.merchant.category;


import com.ecom.merchant.product.ProductDto;
import com.ecom.merchant.product.ProductService;
import com.ecom.merchant.utility.ResponseObj;
import com.ecom.merchant.utility.ReturnStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/category/new")
    public ResponseObj save(@RequestBody @Valid CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.save(categoryDto);
        return ResponseObj.builder().responseBody(savedCategory)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.CREATED)
                .message("Category Created Successfully")
                .build();
    }
    @GetMapping(value = "/category/{id}")
    public ResponseObj getCategoryById(@PathVariable Integer id){
    	CategoryDto category = categoryService.getById(id);
        return ResponseObj.builder().responseBody(category)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.ACCEPTED)
                .message("Category Information loaded Successfully.")
                .build();
    }

    @GetMapping(value = "/categories")
    public ResponseObj getCategories(){
        List<CategoryDto> categories = categoryService.getAll();
        return ResponseObj.builder().responseBody(categories)
                .returnStatus(ReturnStatus.SUCCESS)
                .status(HttpStatus.ACCEPTED)
                .message("Category Information loaded Successfully.")
                .build();
    }
}
