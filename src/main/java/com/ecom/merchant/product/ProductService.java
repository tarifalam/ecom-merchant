package com.ecom.merchant.product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public ProductDto save(ProductDto productDto);
    public Set<ProductDto> getAll();
    public ProductDto getById(Integer productId);
    public ProductDto update(ProductDto productDto);
}
