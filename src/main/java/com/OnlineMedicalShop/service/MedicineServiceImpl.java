package com.OnlineMedicalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Medicine;
import com.OnlineMedicalShop.repository.medicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    medicineRepository medrepo;

	@Override
	public Medicine addMedicine(Medicine p) {
		// TODO Auto-generated method stub
		return medrepo.save(p);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		return medrepo.findAll();
	}

	@Override
	public boolean updateMedicine(Medicine f, int pid) {
		Medicine f1 = medrepo.getById(pid);
		
		if(f.getMedicineDescription()!=null) {
			f1.setMedicineDescription(f.getMedicineDescription());
		}
		if(f.getMedicineName()!=null) {
			f1.setMedicineName(f.getMedicineName());
		}
		
		if(f.getMedicinePrice()!=0) {
			f1.setMedicinePrice(f.getMedicinePrice());
		}
		if(f.getInstock()!=null) {
			f1.setInstock(f.getInstock());
		}
		
		medrepo.save(f1);
		return true;
	}

	@Override
	public Boolean deleteMedicine(int pid) {
		medrepo.deleteById(pid);
		return true;
	}

    
    
}
