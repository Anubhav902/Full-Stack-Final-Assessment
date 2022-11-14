package com.consumer.service.consumerservice.controller;

import com.consumer.service.consumerservice.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("/shop-management/category")
public interface CategoryConsumer {

    @PostMapping("/add-category")
    Category addCategory(@RequestBody Category category);

    @PostMapping("/update-category/{id}")
    Category updateCategory(@PathVariable int id, @RequestBody Category category);

    @PostMapping("/delete-category/{id}")
    void deleteCategory(@PathVariable int id);
}
