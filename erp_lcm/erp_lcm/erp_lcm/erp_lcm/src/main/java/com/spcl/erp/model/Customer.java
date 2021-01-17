package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="new_customer")
public class Customer {
	
	public Customer() {}
	public Customer(int c_id,String c_name,String city,String contact_no,String email_id,String gst_no,
			String note_of_add,String add) {
		this.c_id=c_id;
		this.c_name =c_name;
		this.city =city;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.gst_no =gst_no;
		this.note_of_add = note_of_add;
		this.address=add;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_id;
	
	@Column(name="c_name",length=30)
	private String c_name;
	
	@Column(name="contact_no",length=30)
	private String contact_no;
	
	@Column(name="gst_no",length=30)
	private String gst_no;
	
	@Column(name="email_id",length=30)
	private String email_id;
	
	@Column(name="address",length=30)
	private String address;
	
	@Column(name="city",length=30)
	private String city;
	
	@Column(name="note_of_add",length=30)
	private String note_of_add;
	
	
	@Column(name="c_active",length=30)
	private String c_active;
	

	
	
	
	
	
	public Integer getC_id() {
		return c_id;
	}


	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public String getContact_no() {
		return contact_no;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	public String getGst_no() {
		return gst_no;
	}


	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getNote_of_add() {
		return note_of_add;
	}


	public void setNote_of_add(String note_of_add) {
		this.note_of_add = note_of_add;
	}


	public String getC_active() {
		return c_active;
	}


	public void setC_active(String c_active) {
		this.c_active = c_active;
	}
	
	
	
	
	

}
