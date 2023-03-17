package com.ecom.merchant.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecom.merchant.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer id;

    @NotEmpty
    private String name;

    Category category;

    List<CategoryDto> child = new ArrayList<>();

    public static Category convertToDomain(CategoryDto categoryDto){

        return Category.builder()
                .name(categoryDto.getName())
                .id(categoryDto.getId())
                .category(categoryDto.getCategory())
                .build();
    }

    public static CategoryDto convertToDto(Category category){
        return CategoryDto.builder()
                .name(category.getName())
                .id(category.getId())
                .child(new ArrayList<>())
                .build();
    }

//    private Category getCategoryFromList(Category category,List<Category> categories){
//        categories.stream()
//                .filter(currentCategory -> )
//    }

    public static List<CategoryDto> convertToDtoList(List<Category> categories){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        convertToDtoList(categories,categoryDtos,null,null);
        return categoryDtos;
    }

    private static boolean isParentAlreadyExist(CategoryDto searchDto,List<CategoryDto> categoryDtos){
        for(CategoryDto categoryDto : categoryDtos){
            if(categoryDto.getId() == searchDto.getId()){
                return true;
            }
            return isParentAlreadyExist(searchDto,categoryDto.getChild());
        }
        return false;
    }

    private static void convertToDtoList(List<Category> categories,List<CategoryDto> categoryDtos,
                                                     Category parent,Category child){
        if(parent != null){
            CategoryDto parentDto = CategoryDto.convertToDto(parent);
            CategoryDto childDto = CategoryDto.convertToDto(child);
            boolean isAlreadyExist = isParentAlreadyExist(parentDto,categoryDtos);
            parentDto.getChild().add(childDto);
            if(!isAlreadyExist){
                categoryDtos.add(parentDto);
            }
            return;
        }

        for(Category category : categories){
            if(category.getCategory() != null){
                convertToDtoList(categories,categoryDtos,category.getCategory(),category);
            }
        }
    }

}
