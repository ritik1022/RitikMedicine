package com.OnlineMedicalShop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OnlineMedicalShop.model.Medicine;

@Repository
public interface medicineRepository extends JpaRepository<Medicine,Integer> {
	
	@Query("SELECT m FROM Medicine m WHERE m.instock = 'yes'")
	public List<Medicine> findAllbyInstock(); 
	@Query("SELECT m FROM Medicine m WHERE (m.instock LIKE 'yes') AND (m.medicineName LIKE %?1% "
			+ "OR m.medicineDescription LIKE %?1%"
			+ " OR m.medicinePrice LIKE %?1%)")
	public List<Medicine> homeSearch(String keyword);
	@Query("SELECT m FROM Medicine m WHERE m.instock LIKE 'yes' order by m.medicinePrice")
    public List<Medicine> sortbyMedicinePrice();
	@Query("SELECT m FROM Medicine m WHERE m.instock LIKE 'yes' order by m.medicinePrice desc")
    public List<Medicine> sortbyPriceHigh();
	
}
