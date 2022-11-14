package com.shop.management.Shop_Management.service;

import com.shop.management.Shop_Management.entity.Product;
import com.shop.management.Shop_Management.repository.CategoryRepository;
import com.shop.management.Shop_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        // productRepository.findById(product.getId());
        productRepository.findById(id);
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
