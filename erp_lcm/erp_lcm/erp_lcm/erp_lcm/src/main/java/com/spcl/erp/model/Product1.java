package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product1")
public class Product1 {
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer p1_id;
	
	@Column(name="p1_brand",length=30)
	private String p1_brand;

	public Integer getP1_id() {
		return p1_id;
	}

	public void setP1_id(Integer p1_id) {
		this.p1_id = p1_id;
	}

	public String getP1_brand() {
		return p1_brand;
	}

	public void setP1_brand(String p1_brand) {
		this.p1_brand = p1_brand;
	}
	
	
	

}
