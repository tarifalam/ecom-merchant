package com.ecom.merchant.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Set<ProductDto> getAll() {
        Set<Product> products=productRepository.findAll();
        products.forEach(System.out::println);

       return  ProductDto.convertToListDto(products);
        //return ProductDto.convertToListDto(products).stream().collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Integer productId) {
    	Optional<Product> product=productRepository.findById(productId);    	
    	if(product.isPresent()) {
    		return ProductDto.convertToDto(product.get());
    	}
    	return null;
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return null;
    }
}
