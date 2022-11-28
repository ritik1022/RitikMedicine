package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Admin;
import com.OnlineMedicalShop.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminrepo;
	
	public Boolean verifyAdmin(String email, String password){
		List<Admin> admin = adminrepo.findAll();
		
		
		for(Admin ad : admin){
			if(ad.getEmail().equals(email) && ad.getPassword().equals(password)) { 
				return true;
			}
		}
		throw new ResourceNotFoundException("Admin not Found");
	}
	public Boolean checkEntry(String email) {
		List<Admin> admin = adminrepo.findAll();
		for(Admin ad : admin){
			if(ad.getEmail().equals(email) ) { 
				return true;
			}
		}
		return false;
	}

  

   
}
