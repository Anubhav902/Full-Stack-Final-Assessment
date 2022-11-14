package com.shop.management.Shop_Management.service;

import com.shop.management.Shop_Management.entity.Category;
import com.shop.management.Shop_Management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category) {
        // categoryRepository.findById(product.getId());
        categoryRepository.findById(id);
        return categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
