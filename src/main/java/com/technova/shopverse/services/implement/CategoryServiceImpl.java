package com.technova.shopverse.services.implement;

import com.technova.shopverse.dto.CategoryDTO;
import com.technova.shopverse.model.Category;
import com.technova.shopverse.model.Product;
import com.technova.shopverse.repository.CategoryRepository;
import com.technova.shopverse.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO toDTO(Category category){
        List<String> productsName = null;

        if (category.getProducts() != null){
            productsName = category.getProducts().stream().map(product -> product.getName()).toList();
//            for (Product product : category.getProducts()){
//                productsName.add(product.getName());
//            }
        }
        return new CategoryDTO(category.getId(), category.getName(), category.getDescription(),productsName);
    }

    public CategoryDTO getCategoryDTOById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        List<String> productNames = category.getProducts().stream().map(product -> product.getName()).toList();
        return new CategoryDTO(category.getId(), category.getName(), category.getDescription(), productNames);
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id).map(this::toDTO);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO category) {
        if (category.getName().isEmpty() || category.getName() == null){
            throw new IllegalArgumentException("El nombre de la categoría no puede ser nulo ni estar vacío.");
        }
        if (category.getDescription().length() < 10){
            throw new IllegalArgumentException("La descripción debe tener al menos 10 caracteres.");
        }
        Category nuevaCategoria = new Category(category.getName(), category.getDescription());
        categoryRepository.save(nuevaCategoria);
        return toDTO(nuevaCategoria);
    }

    @Override
    public CategoryDTO updateCategory(Long id,CategoryDTO categoryDetail) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()){
            throw new IllegalArgumentException("La categoria con ID" + id + " no existe");
        }

        Category category = optionalCategory.get();
        category.setName(categoryDetail.getName());
        category.setDescription(categoryDetail.getDescription());

        categoryRepository.save(category);

        return toDTO(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
