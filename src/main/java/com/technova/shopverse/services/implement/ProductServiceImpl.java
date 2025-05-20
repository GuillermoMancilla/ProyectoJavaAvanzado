package com.technova.shopverse.services.implement;

import com.technova.shopverse.dto.ProductDTO;
import com.technova.shopverse.model.Category;
import com.technova.shopverse.model.Product;
import com.technova.shopverse.repository.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO toDTO(Product product){
        String categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), categoryName);
    }

    @Override
    public List<ProductDTO> getAllProductDTOs() {
        return productRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(this::toDTO);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        if (productDto.getName() == null || productDto.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        if (productDto.getPrice() == null || productDto.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (productDto.getCategoryDTO() == null) {
            throw new IllegalArgumentException("Debe indicar una categoria.");
        }
        Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice());
        Category category = categoryRepository.findById(productDto.getCategoryDTO().getId()).orElse(null);
        product.setCategory(category);
        productRepository.save(product);
        return toDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO updated) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }

        Product product = optionalProduct.get();
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());

        productRepository.save(product);

        return toDTO(product);

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
