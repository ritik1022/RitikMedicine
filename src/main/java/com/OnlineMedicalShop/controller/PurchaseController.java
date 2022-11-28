package com.OnlineMedicalShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineMedicalShop.model.Purchase;
import com.OnlineMedicalShop.repository.CartRepository;
import com.OnlineMedicalShop.repository.PurchaseRepository;
import com.OnlineMedicalShop.repository.SignupRepository;
import com.OnlineMedicalShop.service.purchaseService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PurchaseController {



   @Autowired
    PurchaseRepository purchaseRepository;



   @Autowired
    purchaseService purchaseservice;



   @Autowired
    CartRepository cartRepository;



   @Autowired
    SignupRepository signuprepo;



   @GetMapping("/purchase/byEmail/{email}")
    public List<Purchase> customerOrders(@PathVariable String email) {
        return purchaseRepository.getByEmail(email);
    }



   @GetMapping("/purchase/allorders")
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAllByOrderByTransactionidAsc();
    }



   @GetMapping("/purchase/search/{keyword}")
    public List<Purchase> searchPurchase(@PathVariable String keyword) {



       return purchaseRepository.searchPurchase(keyword);
    }



   @SuppressWarnings("rawtypes")
    @PostMapping("/purchase")



   public Boolean create(@RequestBody Purchase su) {
        purchaseRepository.save(su);
        if (purchaseservice.checkEntry(su.getProductname())) {
            return true;
        } else {
            return false;
        }
    }
}