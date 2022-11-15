package com.ecom.merchant.merchant.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDto save(ProductDto productDto){
        Product product = ProductDto.convertToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductDto.convertToDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }

    @Override
    public ProductDto getById(Integer productId) {
        return null;
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return null;
    }
}
