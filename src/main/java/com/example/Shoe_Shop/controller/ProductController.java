package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.Product;
import com.example.Shoe_Shop.Entity.ProductService;
import com.example.Shoe_Shop.Exception.UserNotFoundException;
import com.example.Shoe_Shop.Repository.ProductRepository;
import com.example.Shoe_Shop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get3ProductNew")
    List<Product> get3ProductNew(){
        return  productService.listAll();
    }
    @GetMapping("/getNext3Product/{count}/{limit}")
    List<Product> getNext3Product(@PathVariable("count") int count, @PathVariable("limit") int limit){
        return  productService.findByName(count,limit);
    }
    List<Product> getLastProduct(@PathVariable("count") int count, @PathVariable("limit") int limit){
        return  productService.findByName(count,limit);
    }
    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable("id") int id){
        Product p = productService.findByProductId(id);
//        model.addAttribute("p",p);
//        System.out.println(p.getId());
        Product product = productRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return product;

    }
}
