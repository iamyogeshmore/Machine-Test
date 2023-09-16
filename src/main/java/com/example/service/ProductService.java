package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repositary.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    //--------------------------------- Add Product ---------------------------------
    @Override
    public Product createProduct(ProductDto productDto) {
        log.info("ProductDTO in Service layer {}", productDto);
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        log.info("Product in Service layer {}", product);
        return productRepository.save(product);
    }

    //--------------------------------- Get All Products ---------------------------------
    @Override
    public List<Product> ShowAllproducts() {
        return productRepository.findAll();
    }

    //--------------------------------- Get Product By Id ---------------------------------
    @Override
    public Product getProductByID(int id) {
        Product product = productRepository.getProductById(id);
        log.info("GET-PRODUCT-BY-ID RESPONSE {}", product);
        return product;
    }

    //--------------------------------- Update Product By Id ---------------------------------
    @Override
    public Product updateProductById(Integer id, ProductDto productDto) {
        log.info("UPDATE-PRODUCT-BY-ID REQUEST ProductDto : {}", productDto);
        Product product = productRepository.getProductById(id);
        log.info("UPDATE-PRODUCT-BY-ID BEFORE UPDATE product : {}", product);

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setId(productDto.getCategory().getId());
        category.setType(productDto.getCategory().getType());
        product.setCategory(category);
        log.info("UPDATE-PRODUCT-BY-ID AFTER UPDATE product : {}", product);
        return productRepository.save(product);
    }

    //--------------------------------- Delete Product By Id ---------------------------------
    @Override
    public Object deleteProductByID(Integer id) {
        productRepository.deleteById(id);
        return "Category with id " + id + " deleted.";
    }
}
