package com.OnlineMedicalShop.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Purchase {
	@Id
	private long id;
	private float totalcost;
	private Date dop;
	private int quantity;
	private String productname;
	private String transactionid;
	@OneToOne
	private Signup signup;
	
	public Purchase() {
		super();
	}

	public Purchase(long id, float totalcost, Date dop, int quantity, String productname, String transactionid,
			Signup signup) {
		super();
		this.id = id;
		this.totalcost = totalcost;
		this.dop = dop;
		this.quantity = quantity;
		this.productname = productname;
		this.transactionid = transactionid;
		this.signup = signup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public Signup getSignup() {
		return signup;
	}

	public void setSignup(Signup signup) {
		this.signup =signup;
	}
}
