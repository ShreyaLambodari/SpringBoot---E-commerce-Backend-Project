package com.ecom_proj.ecommerce.service;


import com.ecom_proj.ecommerce.dto.ProductDTO;
import com.ecom_proj.ecommerce.model.Category;
import com.ecom_proj.ecommerce.model.Product;
import com.ecom_proj.ecommerce.repository.CategoryRepo;
import com.ecom_proj.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepo repo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Product> getAllProduct(){
        return repo.findAll();
    }

    public Product getProductById(Long id){
        return repo.findById(id).orElse(null);
    }


    public Product addProduct(ProductDTO productDto){
        Product product = mapDtoToProduct(productDto, new Product());
        return repo.save(product);
    }



    public Product updateProduct(Long id, ProductDTO productDto) {

        Product existingproduct = repo.findById(id).orElse(null);

        if (existingproduct != null) {

            mapDtoToProduct(productDto, existingproduct);
            return repo.save(existingproduct);
        }
        return null;
    }

    private Product mapDtoToProduct(ProductDTO productDto, Product product){
            product.setAvailable(productDto.getAvailable());
            product.setBrand(productDto.getBrand());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setReleasedate(productDto.getReleasedate());

        if (productDto.getCategoryId() != null) {
            Category category = categoryRepo.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException(
                            "Category not found with id: " + productDto.getCategoryId()));
            product.setCategory(category);
        }

        return product;
    }


    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }


}
