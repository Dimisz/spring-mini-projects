package com.uningen.starter.controller;

import com.uningen.starter.model.Product;
import com.uningen.starter.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String postProduct(@RequestParam String name,
                              @RequestParam double price,
                              Model model){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
