package com.example.Shoe_Shop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private String userID;
    private  String address;
    private  String status;
    private  String price;
    private  String phone;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true  ,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItems = new ArrayList<>();
//@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//private List<CartItem> cartItems = new ArrayList<>();


    public Cart() {
    }

    public Cart(Long id, LocalDateTime createdAt, String userID, String address, String status, String price,String phone, List<CartItem> cartItems) {
        this.id = id;
        this.createdAt = createdAt;
        this.userID = userID;
        this.address = address;
        this.status = status;
        this.price = price;
        this.phone = phone;
        this.cartItems = cartItems;
    }

    public Cart(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}