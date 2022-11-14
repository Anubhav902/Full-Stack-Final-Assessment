package com.consumer.service.consumerservice.controller;

import com.consumer.service.consumerservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("/shop-management/product")
public interface ProductConsumer {

    @PostMapping("/add-product")
    Product addProduct(@RequestBody Product product);

    @PostMapping("/update-product/{id}")
    Product updateProduct(@PathVariable int id, @RequestBody Product product);

    @PostMapping("/delete-product/{id}")
    void deleteProduct(@PathVariable int id);
}
