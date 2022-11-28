package com.OnlineMedicalShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Cart;
import com.OnlineMedicalShop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartrepo;
	
	public Cart addtocart(Cart c) {
		return cartrepo.save(c);
		
    
}
}