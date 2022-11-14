package com.shop.management.Shop_Management.controller;

import com.shop.management.Shop_Management.entity.Product;
import com.shop.management.Shop_Management.service.CategoryService;
import com.shop.management.Shop_Management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private CategoryService categoryService;

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/update-product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PostMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
