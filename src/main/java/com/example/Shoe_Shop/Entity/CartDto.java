package com.example.Shoe_Shop.Entity;

import java.util.List;

public class CartDto {
    private Long id;
    private String userID;
    private String address;
    private String status;
    private String price;

    private String phone;
    private List<ProductDto> listProduct;

    public CartDto() {
    }

    public CartDto(Long id,String userID, String address, String status, String price,String phone, List<ProductDto> listProduct) {
        this.id=id;
        this.userID = userID;
        this.address = address;
        this.status = status;
        this.price = price;
        this.phone=phone;
        this.listProduct = listProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public List<ProductDto> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDto> listProduct) {
        this.listProduct = listProduct;
    }
    // constructors, getters, setters
}