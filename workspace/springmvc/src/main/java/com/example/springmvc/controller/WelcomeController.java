package com.example.springmvc.controller;

import com.example.springmvc.domain.Item;
import com.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcome", "Welcome to Spring MVC");
        List<Item> items = Arrays.asList(
                new Item("Apple", 1.25),
                new Item("Banana", 0.75),
                new Item("Orange", 0.50)
        );
        model.addAttribute("items", items);
        return "welcome";
    }
    List<Product> products = Arrays.asList(
            new Product(123,"Smartphone",1000),
            new Product(456,"Laptop",20000),
            new Product(789,"Television",30000),
            new Product(101112,"Refrigerator",50000)

    );

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("products", products);
        return "product";
    }
}
