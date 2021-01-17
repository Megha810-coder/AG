package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="custreport")
public class CustReport {
	
	public CustReport() {}
	 public CustReport(int number,int igst,float cgst,String date,float grossamt,
			 float gstamt1,float netamt,float sgst,String name,String gst,String add){
	  super();
	this.b_number =number;
	this.igst=igst;
	this.cgst = cgst;
	this.date= date;
	this.grossamt= grossamt;
	this.gstamt1 =gstamt1;
	this.netamt =netamt ;
	 this.sgst = sgst ;
	 this.c_name=name;
	 this.c_gst = gst;
	 this.c_add = add;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cr_id;
	
	@Column(name="b_number")
	private Integer b_number;
	
	@Column(name="cr_active")
	private Integer cr_active;
	
	@Column(name="date")
	private String date;
	
	@Column(name="grossamt")
	private float grossamt;
	
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private int igst;
	
	@Column(name="netamt")
	private float netamt;
	
	@Column(name="gstamt1")
	private float gstamt1;

	
	@Column(name="c_name")
			private String c_name;

			@Column(name="c_gst")
			private String c_gst;

			@Column(name="c_add")
			private String c_add;
	
	@OneToOne
	private Customer customer;
	
	
	
//	public Integer getB_id() {
//		return b_id;
//	}
//
//	public void setB_id(Integer b_id) {
//		this.b_id = b_id;
//	}

	public Integer getCr_id() {
		return cr_id;
	}
	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}
	public Integer getB_number() {
		return b_number;
	}

	public void setB_number(Integer b_number) {
		this.b_number = b_number;
	}

	public Integer getCr_active() {
		return cr_active;
	}

	public void setCr_active(Integer cr_active) {
		this.cr_active = cr_active;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getGrossamt() {
		return grossamt;
	}

	public void setGrossamt(float grossamt) {
		this.grossamt = grossamt;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public int getIgst() {
		return igst;
	}

	public void setIgst(int igst) {
		this.igst = igst;
	}

	public float getNetamt() {
		return netamt;
	}

	public void setNetamt(float netamt) {
		this.netamt = netamt;
	}

	public float getGstamt1() {
		return gstamt1;
	}

	public void setGstamt1(float gstamt1) {
		this.gstamt1 = gstamt1;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	


}
