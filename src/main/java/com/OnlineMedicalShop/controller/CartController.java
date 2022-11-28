package com.OnlineMedicalShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineMedicalShop.model.Cart;
import com.OnlineMedicalShop.repository.CartRepository;
import com.OnlineMedicalShop.repository.medicineRepository;
import com.OnlineMedicalShop.service.CartService;
import com.OnlineMedicalShop.repository.SignupRepository;

@CrossOrigin(origins = "http://localhost:4200/userlogin",allowedHeaders = "*")
@RestController



public class CartController{
    @Autowired
    CartService cartservice;
    
    @Autowired
    medicineRepository mr;
    
    @Autowired
    CartRepository cr;
    
    @Autowired
    SignupRepository sr;
    @PostMapping("/addcart")
    public boolean addToCart(@RequestBody Cart cart)
    {
        Cart f1 = cartservice.addtocart(cart);
        if (f1!=null) {
            return true;
        }
        else {
            return false;
        }
    }
}