package com.OnlineMedicalShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medicine")
public class Medicine {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   	public int medicineId;
    @NotNull(message = "medicine Name can not be empty")
    public String medicineName;
  
   	public float medicinePrice;
   	public String medicineDescription;
   	public String instock; 
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	 }
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public float getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(float medicinePrice) {                                                                                                
		this.medicinePrice = medicinePrice;
	}
	public String getMedicineDescription() {
		return medicineDescription;
	}
	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}
	public String getInstock() {
		return instock;
	}
	public void setInstock(String medicineAvailability) {
		this.instock = medicineAvailability;
	}
   	


    
}
