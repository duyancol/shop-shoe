package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.Product;
import com.example.Shoe_Shop.Entity.ProductService;
import com.example.Shoe_Shop.Repository.ProductRepository;
import com.example.Shoe_Shop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired private ProductRepository productRepository;

    @Autowired private ProductDao productDao;
    @GetMapping("getAllProduct")
    List<Product> getProductAll(){
        return  productService.listAllProduct();
    }
}