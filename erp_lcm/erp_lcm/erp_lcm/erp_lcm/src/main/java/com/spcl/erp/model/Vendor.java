package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="new_vendor")
public class Vendor {
	
	public Vendor() {}
	public Vendor(int v_id,String v_name,String conatct_no,String address,String city,
			String email_id,String website,Float cgst,Float sgst,Float igst) {
		this.v_id=v_id;
		this.v_name =v_name;
		this.conatct_no =conatct_no;
		//this.Gst_no = Gst_no;
		this.address = address;
		this.city =city;
		this.email_id = email_id;
		this.website=website;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer v_id;
	
	@Column(name="v_name",length=30)
	private String  v_name;
	
	@Column(name="conatct_no",length=30)
	private String conatct_no ;
	
	@Column(name="gst_no",length=30)
	private String gst_no ;
	
	/*
	 * @Column(name="Gst_no",length=30) private String Gst_no;
	 */
	
	@Column(name="address",length=30)
	private String address;
	
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	@Column(name="city",length=30)
	private String city;
	
	@Column(name="email_id",length=30)
	private String email_id;
	
	@Column(name="website",length=30)
	private String website;
	
	@Column(name="cgst")
	private Float cgst;
	
	@Column(name="sgst")
	private Float sgst;
	
	@Column(name="igst")
	private Float igst;
	
	@Column(name="v_active")
	private Integer v_active;

	public Integer getV_id() {
		return v_id;
	}

	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getConatct_no() {
		return conatct_no;
	}

	public void setConatct_no(String conatct_no) {
		this.conatct_no = conatct_no;
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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Float getCgst() {
		return cgst;
	}

	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}

	public Float getSgst() {
		return sgst;
	}

	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	public Float getIgst() {
		return igst;
	}

	public void setIgst(Float igst) {
		this.igst = igst;
	}

	public Integer getV_active() {
		return v_active;
	}

	public void setV_active(Integer v_active) {
		this.v_active = v_active;
	}
	
	
	
	

}
