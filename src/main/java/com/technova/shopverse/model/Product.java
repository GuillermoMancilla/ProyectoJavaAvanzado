package com.technova.shopverse.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id") // Esta será la clave foránea en la base de datos
    private Category category;

    public Product() {
    }

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product(String name, String description, Double price,Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    //Constructor para springBatch
//    public Product(Long id, String name, String description, Double price, Category category) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
