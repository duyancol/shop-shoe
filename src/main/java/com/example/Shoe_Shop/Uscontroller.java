package com.example.Shoe_Shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/user")
public class Uscontroller {
    @GetMapping
    public String help(){
        return  " hello";
    }
}
