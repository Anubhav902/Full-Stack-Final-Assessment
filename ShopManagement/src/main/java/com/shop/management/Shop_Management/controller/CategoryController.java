package com.shop.management.Shop_Management.controller;

import com.shop.management.Shop_Management.entity.Category;
import com.shop.management.Shop_Management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/update-category/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @PostMapping("/delete-category/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
