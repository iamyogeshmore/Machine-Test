package com.example.service;


import com.example.dto.CategoryDto;
import com.example.model.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDto categoryDto);

    Category getCategoryByID(Integer id);

    Category updateCategoryById(Integer id, CategoryDto categoryDto);

    String deleteCategoryByID(Integer id);

    List<Category> ShowAllCategory();
}
