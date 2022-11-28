package com.OnlineMedicalShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="cart")
public class Cart {

    @Id
    private int id;
    private int quantity;
    private float prize;
    @OneToOne
    private Medicine medicine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
  
    
    
}
