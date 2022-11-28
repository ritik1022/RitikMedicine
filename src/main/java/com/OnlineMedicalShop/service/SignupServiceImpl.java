package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Signup;
import com.OnlineMedicalShop.repository.SignupRepository;

@Service
public class SignupServiceImpl implements signupService{
    @Autowired
    SignupRepository sur;
    public Boolean verifyUser(String email, String password){
		List<Signup> s = sur.findAll();
		for(Signup su : s){
			if(su.getEmail().equals(email) && su.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
 public Boolean checkEntry(String email) {
		List<Signup> s = sur.findAll();
		for(Signup su : s){
			if(su.getEmail().equals(email) ) { 
				return true;
			}
		}
		return false;
	}
 public Boolean updateUser(int id,Signup su) {
		Signup s = sur.getById(id);
		if(su.getPassword()!=null) {
			s.setPassword(su.getPassword());
		}
		if(su.getEmail()!=null) {
			s.setEmail(su.getEmail());
		}
		if(su.getName()!=null) {
			s.setName(su.getName());
		}
		if(su.getMobilenumber()!=0) {
			s.setMobilenumber(su.getMobilenumber());
		}
		if(su.getAddress()!=null){
			s.setAddress(su.getAddress());
		}
		
		
		sur.save(s);
		return true;
	}
}