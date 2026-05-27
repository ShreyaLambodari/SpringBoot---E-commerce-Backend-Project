package com.ecom_proj.ecommerce.controller;


import com.ecom_proj.ecommerce.dto.ProductDTO;
import com.ecom_proj.ecommerce.model.Product;
import com.ecom_proj.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping("/")
//    public String greet(){
//        return "Hello";
//    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody ProductDTO productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDto){
        return productService.addProduct(productDto);
    }
}
