package com.OnlineMedicalShop.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	public Boolean verifyAdmin(String email, String password);
	public Boolean checkEntry(String email);
	
}
