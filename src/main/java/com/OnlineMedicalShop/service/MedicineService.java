package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Medicine;

@Service
public interface MedicineService {

    public Medicine addMedicine(Medicine p);
    public List<Medicine> getAllMedicine();
    public boolean updateMedicine(Medicine p, int pid);
    public Boolean deleteMedicine(int pid);

    
}
