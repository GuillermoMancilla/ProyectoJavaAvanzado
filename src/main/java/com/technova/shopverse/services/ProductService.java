package com.technova.shopverse.services;

import com.technova.shopverse.dto.ProductDTO;
import com.technova.shopverse.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProductDTOs();
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product updated);
    void deleteProductByID(Long id);
    List<ProductDTO> getByCategoryId(Long categoryId);
}
