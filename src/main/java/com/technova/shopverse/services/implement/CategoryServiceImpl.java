package com.technova.shopverse.services.implement;

import com.technova.shopverse.model.Category;
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
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        if (category.getName().isEmpty() || category.getName() == null){
            throw new IllegalArgumentException("El nombre de la categoría no puede ser nulo ni estar vacío.");
        }
        if (category.getDescription().length() < 10){
            throw new IllegalArgumentException("La descripción debe tener al menos 10 caracteres.");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id,Category categoryDetail) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()){
            throw new IllegalArgumentException("La categoria con ID" + id + " no existe");
        }

        Category category = optionalCategory.get();
        category.setName(categoryDetail.getName());
        category.setDescription(categoryDetail.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
