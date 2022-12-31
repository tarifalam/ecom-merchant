package com.ecom.merchant.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.merchant.product.Product;
import com.ecom.merchant.product.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDto save(CategoryDto categoryDto){
        Category category = CategoryDto.convertToDomain(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryDto.convertToDto(savedCategory);
    }

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }

    @Override
    public CategoryDto getById(Integer categoryId) {
    	Optional<Category> category=categoryRepository.findById(categoryId);    	
    	if(category.isPresent()) {
    		return CategoryDto.convertToDto(category.get());
    	}
    	return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }
}
