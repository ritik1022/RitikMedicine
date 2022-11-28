package com.OnlineMedicalShop.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.OnlineMedicalShop.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	//@Query("SELECT f FROM payment")
	//public List<Payment> allpayment();

}