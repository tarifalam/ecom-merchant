package com.ecom.merchant.merchant.category;

import java.util.List;

public interface CategoryService {
    public CategoryDto save(CategoryDto categoryDto);
    public List<CategoryDto> getAll();
    public CategoryDto getById(Integer productId);
    public CategoryDto update(CategoryDto categoryDto);
}
