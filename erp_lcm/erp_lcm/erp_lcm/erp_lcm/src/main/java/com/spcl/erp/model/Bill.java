package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="bill")
public class Bill {
	
	public Bill() {}
	 public Bill(int number,int igst,float cgst,String date,float grossamt,
	 float gstamt1,float netamt,float sgst){
	  super();
	//this.b_id = id1;
	this.b_number =number;
	//this.gstPer=per;
	//this.gstType = type ;
	this.igst=igst;
	//this.quantity = quantity;
	//this.Amount = amount;
	this.cgst = cgst;
	this.date= date;
	this.grossamt= grossamt;
	//this.gstAmount=gstamt;
	this.gstamt1 =gstamt1;
	this.netamt =netamt ;
	 this.sgst = sgst ;
	 // this.rate = rate;
	  //this.total = total;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer b_id;
	
	@Column(name="b_number")
	private Integer b_number;
	
	@Column(name="b_active")
	private Integer b_active;
	
	@Column(name="date")
	private String date;
	
	@Column(name="grossamt")
	private float grossamt;
	
	@Column(name="gstPer")
	private Integer gstPer;
	
	@Column(name="gstType")
	private Integer gstType;
	
	@Column(name="total")
	private float total;
	
	
	@Column(name="quantity")
	private Integer quantity;
	

	@Column(name="gstAmount")
	private float gstAmount;
	
	@Column(name="Amount")
	private float Amount;
	
	@Column(name="rate")
	private float rate;
	
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
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private Customer customer;

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public Integer getB_number() {
		return b_number;
	}

	public void setB_number(Integer b_number) {
		this.b_number = b_number;
	}

	public Integer getB_active() {
		return b_active;
	}

	public void setB_active(Integer b_active) {
		this.b_active = b_active;
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

	public Integer getGstPer() {
		return gstPer;
	}

	public void setGstPer(Integer gstPer) {
		this.gstPer = gstPer;
	}

	public Integer getGstType() {
		return gstType;
	}

	public void setGstType(Integer gstType) {
		this.gstType = gstType;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(float gstAmount) {
		this.gstAmount = gstAmount;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
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
	
	

	
	
	
	
	
	
	
	

	
	
}
