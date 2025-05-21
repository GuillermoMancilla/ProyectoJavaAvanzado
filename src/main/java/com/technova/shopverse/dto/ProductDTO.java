package com.technova.shopverse.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class ProductDTO {
    private Long id;
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Double price;
    private String categoryName;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;
    @NotNull(message = "La categoría es obligatoria")
    private CategoryDTO categoryDTO;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, String description, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
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
