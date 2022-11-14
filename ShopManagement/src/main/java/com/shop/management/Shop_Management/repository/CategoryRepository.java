package com.shop.management.Shop_Management.repository;

import com.shop.management.Shop_Management.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
