package com.technova.shopverse.services.implement;

import com.technova.shopverse.dto.ProductDTO;
import com.technova.shopverse.model.Product;
import com.technova.shopverse.repository.ProductRepository;
import com.technova.shopverse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO toDTO(Product product){
        String categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), categoryName);
    }

    @Override
    public List<ProductDTO> getAllProductDTOs() {
        return productRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updated) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }

        Product product = optionalProduct.get();
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());

        return productRepository.save(product);

    }

    @Override
    public void deleteProductByID(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(this::toDTO).toList();
    }


}
