package com.technova.shopverse.services;

import com.technova.shopverse.dto.CategoryDTO;
import com.technova.shopverse.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDTO getCategoryDTOById(Long id);
    List<CategoryDTO> getAllCategories();
    Optional<CategoryDTO> getCategoryById(Long id);
    CategoryDTO createCategory(CategoryDTO category);
    CategoryDTO updateCategory(Long id,CategoryDTO categoryDetail);
    void deleteCategory(Long id);

}
