package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.dto.Response;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private ICategoryService categoryService;
    List<Category> categoryList = new ArrayList<>();


    //--------------------------------- Add Category ---------------------------------
    @PostMapping("/categories")
    public ResponseEntity<Response> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.createCategory(categoryDto);
        Response response = new Response("Category added successfully", category);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Get all Categories ---------------------------------
    @GetMapping("/ShowAllCategory")
    public ResponseEntity<Response> ShowAllCategory() {
        categoryList = categoryService.ShowAllCategory();
        Response response = new Response("All Categories data retrieved successfully.", categoryList);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    //--------------------------------- Get Category By Id ---------------------------------
    @GetMapping("/getById/{id}")
    public ResponseEntity<Response> getById(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.getCategoryByID(id);
        Response response = new Response("Get Call Success for id successful", category);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Update Category By Id ---------------------------------
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Response> updateById(@PathVariable(value = "id") Integer id, @RequestBody CategoryDto categoryDto) {
        Category category = categoryService.updateCategoryById(id, categoryDto);
        Response response = new Response("Updated Successfully", category);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Delete Category By Id ---------------------------------
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable(value = "id") Integer id) {
        Response response = new Response("Delete Call Success for id successful",
                categoryService.deleteCategoryByID(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
