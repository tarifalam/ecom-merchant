package com.ecom.merchant.product;

import java.util.List;

public interface ProductService {
    public ProductDto save(ProductDto productDto);
    public List<ProductDto> getAll();
    public ProductDto getById(Integer productId);
    public ProductDto update(ProductDto productDto);
}
