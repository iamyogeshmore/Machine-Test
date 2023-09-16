package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(ProductDto productDto);

    Product getProductByID(int id);

    Product updateProductById(Integer id, ProductDto productDto);

    Object deleteProductByID(Integer id);

    List<Product> ShowAllproducts();
}
