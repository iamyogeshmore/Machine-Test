package com.example.service;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import com.example.repositary.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //--------------------------------- Add Category ---------------------------------
    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto);
        return categoryRepository.save(category);
    }

    //--------------------------------- Get Category By Id ---------------------------------
    @Override
    public Category getCategoryByID(Integer id) {
        Category category = categoryRepository.getCategoryById(id);
        log.info("Category {}", category);
        return category;
    }

    //--------------------------------- Get All Category ---------------------------------
    @Override
    public List<Category> ShowAllCategory() {
        return categoryRepository.findAll();
    }

    //--------------------------------- Update Category By Id ---------------------------------
    @Override
    public Category updateCategoryById(Integer id, CategoryDto categoryDto) {
        Category category = categoryRepository.getCategoryById(id);
        category.setType(categoryDto.getType());
        return categoryRepository.save(category);
    }

    //--------------------------------- Delete Category By Id ---------------------------------
    @Override
    public String deleteCategoryByID(Integer id) {
        categoryRepository.deleteById(id);
        return "Category with id " + id + " deleted.";
    }
}
