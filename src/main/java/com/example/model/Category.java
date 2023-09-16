package com.example.model;

import com.example.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;
    private String type;

    public Category(CategoryDto categoryDto) {
        updateCategory(categoryDto);
    }

    public void updateCategory(CategoryDto categoryDto) {
        this.id = categoryDto.getId();
        this.type = categoryDto.getType();
    }
}
