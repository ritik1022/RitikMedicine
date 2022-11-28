package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Payment;

@Service
public interface purchaseService {
    public Boolean checkEntry(String name);
}
