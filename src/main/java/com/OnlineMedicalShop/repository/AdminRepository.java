package com.OnlineMedicalShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineMedicalShop.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
   
}
