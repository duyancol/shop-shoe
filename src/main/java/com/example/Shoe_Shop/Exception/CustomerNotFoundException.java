package com.example.Shoe_Shop.Exception;

public class CustomerNotFoundException extends  Exception{
    public CustomerNotFoundException(String mess){
        super(mess);
    }
}