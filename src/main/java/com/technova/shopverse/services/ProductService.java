package com.technova.shopverse.services;

import com.technova.shopverse.dto.ProductDTO;
import com.technova.shopverse.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProductDTOs();
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDto);
    ProductDTO updateProduct(Long id, ProductDTO updated);
    void deleteProductByID(Long id);
    List<ProductDTO> getByCategoryId(Long categoryId);
}
