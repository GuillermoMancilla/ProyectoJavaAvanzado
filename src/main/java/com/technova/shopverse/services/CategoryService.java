package com.technova.shopverse.services;

import com.technova.shopverse.dto.CategoryDTO;
import com.technova.shopverse.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDTO getCategoryDTOById(Long id);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id,Category categoryDetail);
    void deleteCategory(Long id);

}
