package com.example.controller;

import com.example.dto.ProductDto;
import com.example.dto.Response;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    List<Product> productList = new ArrayList<>();

    //--------------------------------- Add Product ---------------------------------
    @PostMapping("/product")
    public ResponseEntity<Response> addProduct(@RequestBody ProductDto productDto) {

        Product product = productService.createProduct(productDto);
        Response response = new Response("Product added successfully", product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //--------------------------------- Get all products ---------------------------------
    @GetMapping("/ShowAllproducts")
    public ResponseEntity<Response> ShowAllproducts() {
        productList = productService.ShowAllproducts();
        Response response = new Response("All product data retrieved successfully.", productList);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    //--------------------------------- Get Product By Id ---------------------------------
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Response> getById(@PathVariable(value = "id") Integer id) {

        Product product = productService.getProductByID(id);
        Response response = new Response("Get Call Success for id successful", product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Update Product By Id ---------------------------------
    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<Response> updateById(@PathVariable(value = "id") Integer id,
                                               @RequestBody ProductDto productDto) {
        Product product = productService.updateProductById(id, productDto);
        Response response = new Response("Product updated successfully", product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Delete Product By Id ---------------------------------
    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable(value = "id") Integer id) {
        Response response = new Response("Delete Call Success for id successful",
                productService.deleteProductByID(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
