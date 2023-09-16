package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity

@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    private String productName;
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(int id, String productName, int price, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

}
