package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="product_details")
public class Product_details {
	
	public Product_details() {}
	 public Product_details(int pd_id,int p_id,int c_id,int packages,int box,int qty,float rate,int size){
	  super();
	  this.pd_id = pd_id;
	  this.p_id =p_id;
	  this.c_id=c_id;
	  this.packages = packages;
	  this.rate = rate;
	  this.size =size;
	  this.box =box;
	  this.quantity = qty;

	}
	 
	 public Product_details(String p_name,float rate,String HSN,String uom){
		 
		  this.pro_name = p_name;
		  this.rate =rate;
		  this.p_HSN=HSN;
		  this.pro_uom=uom;
		}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pd_id;
	

	@Column(name="p_id")
	private Integer p_id;
	
	@Column(name="p_HSN")
	private String p_HSN;
	
	@Column(name="c_id")
	private Integer c_id;
	
	
	@Column(name="pro_name")
	private String pro_name;
	
	
	@Column(name="packages")
	private Integer packages;
	
	@Column(name="size")
	private Integer size;
	
	@Column(name="quantity")
	private Integer  quantity;
	
	@Column(name="rate")
	private Float rate;
	
	@Column(name="box")
	private Integer box;
	
	@Column(name="pd_active",length=5)
	private String pd_active;
	
	@Column(name="pro_uom")
	private String  pro_uom;
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private Customer customer;
	
	

	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}

	public Integer getPackages() {
		return packages;
	}

	public void setPackages(Integer packages) {
		this.packages = packages;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Integer getBox() {
		return box;
	}

	public void setBox(Integer box) {
		this.box = box;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPd_active() {
		return pd_active;
	}

	public void setPd_active(String pd_active) {
		this.pd_active = pd_active;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getP_HSN() {
		return p_HSN;
	}
	public void setP_HSN(String p_HSN) {
		this.p_HSN = p_HSN;
	}
	public String getPro_uom() {
		return pro_uom;
	}
	public void setPro_uom(String pro_uom) {
		this.pro_uom = pro_uom;
	}
	
	
	
	
	
	
	
	
	
}
