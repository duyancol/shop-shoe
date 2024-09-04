package com.example.Shoe_Shop.Exception;

public class CartNotFoundException extends  RuntimeException{
    public CartNotFoundException(long id){
        super("Cound not" +id);
    }
}

