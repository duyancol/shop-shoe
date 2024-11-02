package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.Product;
import com.example.Shoe_Shop.Entity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @GetMapping("show")
    List<Product> getProductAll(){

        return  productService.listAllProduct();

    }
}
