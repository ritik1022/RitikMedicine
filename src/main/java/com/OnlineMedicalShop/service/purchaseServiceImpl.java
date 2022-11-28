package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Purchase;
import com.OnlineMedicalShop.repository.PurchaseRepository;

@Service
public class purchaseServiceImpl implements purchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
	public Boolean checkEntry(String name) {
    	List<Purchase> s = purchaseRepository.findAll();
		for(Purchase su : s){
			if(su.getProductname().equals(name) ) { 
				return true;
			}
		}
		return false;
	}
}
