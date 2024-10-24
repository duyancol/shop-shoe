package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.Cart;
import com.example.Shoe_Shop.Entity.CartDto;
import com.example.Shoe_Shop.Entity.CartService;
import com.example.Shoe_Shop.Exception.CartNotFoundException;
import com.example.Shoe_Shop.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class OrderHistoryWithUser {
    @Autowired
    private CartRepository cartRepository;
    @GetMapping("/order/{id}")
    public List<Cart> getCartsByUserId(@PathVariable String id) {
        List<Cart> carts = cartRepository.findByUserID(id);
        for (Cart cart : carts) {
            // load cartItems if necessary
            cart.getCartItems();
        }
        return carts;
    }
    @PutMapping("/updateStatusHuy")
    public Cart updateStatusHuyDonhang(@RequestParam("id") long id){

        Cart cart = cartRepository.findById(id).map(c->{
            c.setStatus("0");

            return cartRepository.save(c);
        }).orElseThrow(()-> new CartNotFoundException(id));
        return cart;

    }
    @Autowired
    private CartService cartService;
    @GetMapping("/cart/{userId}")
    public ResponseEntity<CartDto> getCartByUserId(@PathVariable String userId) {
        CartDto cartDto = cartService.getCartWithProductsByUserId(userId);
        if (cartDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartDto);
    }
}
