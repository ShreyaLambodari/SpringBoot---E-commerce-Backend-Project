package com.ecom_proj.ecommerce.controller;

import com.ecom_proj.ecommerce.model.Category;
import com.ecom_proj.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categService;

    @GetMapping
    public List<Category> getCategory(){
        return categService.getCategory();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categService.getById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,
                                   @RequestBody Category category){
        return categService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategById(Long id){
        categService.deleteCategById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categService.addCategory(category);
    }

}
