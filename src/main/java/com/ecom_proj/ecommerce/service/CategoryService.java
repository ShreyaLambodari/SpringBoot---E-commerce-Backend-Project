package com.ecom_proj.ecommerce.service;


import com.ecom_proj.ecommerce.model.Category;
import com.ecom_proj.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categRepo;

    public List<Category> getCategory(){
        return categRepo.findAll();
    }

    public Category getById(Long id) {
        return categRepo.findById(id).orElse(null);
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categRepo.findById(id).orElse(null);

        if(existingCategory != null){
            existingCategory.setCategoryName(category.getCategoryName());

            return categRepo.save(existingCategory);
        }
        return null;
    }

    public void deleteCategById(Long id) {
        categRepo.deleteById(id);
    }

    public Category addCategory(Category category) {
        return categRepo.save(category);
    }
}
