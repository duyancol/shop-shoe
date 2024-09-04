package com.example.Shoe_Shop.Exception;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(int id){
        super("Cound not" +id);
    }
}