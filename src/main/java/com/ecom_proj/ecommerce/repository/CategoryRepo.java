package com.ecom_proj.ecommerce.repository;

import com.ecom_proj.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
