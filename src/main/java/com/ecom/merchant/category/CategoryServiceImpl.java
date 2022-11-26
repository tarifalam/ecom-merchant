package com.ecom.merchant.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }
}
