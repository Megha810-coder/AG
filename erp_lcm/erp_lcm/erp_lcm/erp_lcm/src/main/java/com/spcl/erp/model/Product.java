package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="product")
public class Product {
	
	public Product() {}
	 public Product(int p_id,String p_name,String p_code,String p_brand,Integer packages,Float rate,String size,String uom, Integer quantity){
	  super();
	      this.p_id = p_id;
	  this.p_name =p_name;
	  this.p_code = p_code;
	  this.p_brand = p_brand;
	  this.packages = packages;
	  this.rate = rate;
	  this.size =size;
	  this.uom =uom;
	  this.min_quantity = quantity;

	}
	 
	 public Product(String p_name,String uom){
		 
		  this.p_name = p_name;
		  this.uom = uom;
		}
	 
	 public Product(int minqty,int packages,String p_name){
		 
		  this.min_quantity = minqty;
		  this.packages = packages;
		  this.p_name = p_name;
		}


	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer p_id;
	
	@Column(name="p_brand",length=30)
	private String p_brand;
	
	
	@Column(name="p_name",length=30)
	private String p_name;
	
	@Column(name="p_code",length=30)
	private String p_code;
	
	@Column(name="size",length=30)
	private String size;
	
	@Column(name="rate")
	private Float rate;
	
	@Column(name="packages",length=30)
	private Integer packages;
	
	@Column(name="min_quantity",length=30)
	private Integer min_quantity;
	
	@Column(name="uom",length=30)
	private String uom;
	
	@Column(name="p_active",length=5)
	private String p_active;
	
	@Column(name="quantity",length=30)
	private Integer quantity;
	


	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_brand() {
		return p_brand;
	}

	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Integer getPackages() {
		return packages;
	}

	public void setPackages(Integer packages) {
		this.packages = packages;
	}

	public Integer getMin_quantity() {
		return min_quantity;
	}

	public void setMin_quantity(Integer min_quantity) {
		this.min_quantity = min_quantity;
	}

	public String getP_active() {
		return p_active;
	}

	public void setP_active(String p_active) {
		this.p_active = p_active;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	
	
	
	
	
}
