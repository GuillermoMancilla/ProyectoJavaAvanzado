package com.technova.shopverse.dto;

import java.util.Set;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String categoryName;
    private String description;
    private CategoryDTO categoryDTO;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
    }

    public ProductDTO(Long id, String name, Double price, String description, CategoryDTO categoryDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryDTO = categoryDTO;
    }

    public ProductDTO(Long id, String name, Double price, String categoryName, String description, CategoryDTO categoryDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryName = categoryName;
        this.categoryDTO = categoryDTO;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
