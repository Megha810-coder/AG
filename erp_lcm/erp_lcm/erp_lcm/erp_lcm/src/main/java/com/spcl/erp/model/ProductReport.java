package com.spcl.erp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="product_report")
public class ProductReport {
	
	public ProductReport() {}
	 public ProductReport(String pr_name,Date pr_date, long quantity){
	  super();
	   //   this.pr_id = pr_id;
	  this.name =pr_name;
	  this.date = pr_date;
	  this.quantity = quantity;


	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pr_id;
	
	@Column(name="date",length=30)
	private Date date;
	
	
	@Column(name="quantity")
	private long quantity;
	
	@Column(name="pr_active",length=30)
	private String pr_active;
	
	@Column(name="name",length=30)
	private String name;
	
	@OneToOne
	private Product product;

	public Integer getPr_id() {
		return pr_id;
	}

	public void setPr_id(Integer pr_id) {
		this.pr_id = pr_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	
	

	public String getPr_active() {
		return pr_active;
	}

	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public void setPr_active(String pr_active) {
		this.pr_active = pr_active;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	

}
