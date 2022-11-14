package com.consumer.service.consumerservice.controller;

import com.consumer.service.consumerservice.model.Category;
import com.consumer.service.consumerservice.model.Product;
import com.consumer.service.consumerservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    AdminConsumer adminConsumer;

    @Autowired
    CategoryConsumer categoryConsumer;

    @Autowired
    ProductConsumer productConsumer;

    @Autowired
    JwtTokenConsumer jwtTokenConsumer;

    //-----------------------------------TOKEN-SERVICE CONSUMER--------------------------------------//

    @GetMapping("/get-token/{id}")
    String createToken(@PathVariable("id") int id){
        return jwtTokenConsumer.createToken(id);
    }



    @GetMapping("/get-users")
    List<User> getUsers(){
        System.out.println(adminConsumer.getClass().getSimpleName());
        System.out.println("accessing from admin-service");
        return adminConsumer.getUsers();
    }

    @PostMapping(value = "/signup")
    public String signup(@RequestBody User user) {
        return adminConsumer.signup(user);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String, Object> map){

            String initial_response = adminConsumer.login(map);

            if (!initial_response.contains("data"))
                return initial_response;

            int id_index = initial_response.indexOf("id") + 5;
            String id = initial_response.substring(id_index,
                    initial_response.indexOf(",", id_index));


            String token = createToken(id);

    }


    @GetMapping("/shop-management/categories")
    public List<Category> getCategories(){
        return categoryConsumer.getCategories();
    }


    @RequestMapping(value = "/shop-management/add-category")
    public String addCategory(@RequestBody Category category){
            return categoryConsumer.addCategory(category).toString();
    }


    @RequestMapping(value = "/shop-management/delete-category-by-id/{id}")
    public String deleteCategoryById(@PathVariable("id") int category_id){

            return categoryConsumer.deleteCategoryById(category_id);
    }



    @GetMapping("/shop-management/products")
    public List<Product> getProducts(){
        return productConsumer.getProducts();
    }


    @RequestMapping(value = "/shop-management/add-products")
    public String addProducts(@RequestBody List<Product> products) {
        return productConsumer.addProducts(products).toString();
    }

    @RequestMapping(value = "/shop-management/add-product")
    public String addProduct(@RequestBody Product product){
            return productConsumer.addProduct(product).toString();

    }
}
