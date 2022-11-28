package com.OnlineMedicalShop.service;

import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Signup;

@Service
public interface signupService {
	 public Boolean verifyUser(String email, String password);
	 public Boolean checkEntry(String email);
	 public Boolean updateUser(int id,Signup su);
}
