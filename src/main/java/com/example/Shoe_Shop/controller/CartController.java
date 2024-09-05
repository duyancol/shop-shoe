package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/save")
    public ResponseEntity<String> saveCart(@RequestBody String cartJson) {
        //String s =  "{items"+": " +cartJson+"}";
        cartService.saveCart(cartJson);
        return ResponseEntity.ok().build();
    }
}
