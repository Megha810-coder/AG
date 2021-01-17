package com.spcl.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_hr_requirement")
public class HrRequirement {
	

	public HrRequirement() {}
	public HrRequirement(int hr_req_id,String hr_created_date, String hr_department, String hr_shifts,String labour_required) {
	super();
	this.hr_req_id = hr_req_id;
	this.hr_created_date = hr_created_date;
	this.hr_department = hr_department;
	this.hr_shifts=hr_shifts;
	this.labour_required = labour_required;

	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hr_req_id;
	
	@Column(name="hr_department",length=30)
	private String hr_department;
	
	@Column(name="hr_shifts",length=30)
	private String hr_shifts;
	
	@Column(name="hr_created_date")
	private String hr_created_date;
	
	/*
	 * @Column(name="hr_created_date", length=30) private String hr_created_date;
	 */
	
	public String getHr_created_date() {
		return hr_created_date;
	}
	public void setHr_created_date(String hr_created_date) {
		this.hr_created_date = hr_created_date;
	}

	/*
	 * public Date getHr_created_date() { return hr_created_date; } public void
	 * setHr_created_date(Date hr_created_date) { this.hr_created_date =
	 * hr_created_date; }
	 */
	/*
	 * public String getHr_created_date() { return hr_created_date; } public void
	 * setHr_created_date(String hr_created_date) { this.hr_created_date =
	 * hr_created_date; }
	 */
	@Column(name="labour_required", length=30)
	private String labour_required;
	
	@Column(name="hr_active",length=2)
	private Integer hr_active;
	
//	@Column(name="hr_created_date", nullable=true)
//	@Temporal(TemporalType.DATE)
//	private Date hr_created_date;
//	
//	public Date getHr_created_date() {
//		return hr_created_date;
//	}
	/*
	 * @Column(name="hr_updated_date", nullable=true)
	 * 
	 * @Temporal(TemporalType.DATE) private Date hr_updated_date;
	 */


	/* private Department_type department; */
	

	
	
//	public void setHr_created_date(Date hr_created_date) {
//		this.hr_created_date = hr_created_date;
//	}


	/*
	 * public Date getHr_updated_date() { return hr_updated_date; }
	 * 
	 * public void setHr_updated_date(Date hr_updated_date) { this.hr_updated_date =
	 * hr_updated_date; }
	 */

	public Integer getHr_active() {
		return hr_active;
	}

	public void setHr_active(Integer hr_active) {
		this.hr_active = hr_active;
	}

	public Integer getHr_req_id() {
		return hr_req_id;
	}

	public void setHr_req_id(Integer hr_req_id) {
		this.hr_req_id = hr_req_id;
	}

	public String getHr_department() {
		return hr_department;
	}

	public void setHr_department(String hr_department) {
		this.hr_department = hr_department;
	}

	public String getHr_shifts() {
		return hr_shifts;
	}

	public void setHr_shifts(String hr_shifts) {
		this.hr_shifts = hr_shifts;
	}

	public String getLabour_required() {
		return labour_required;
	}

	public void setLabour_required(String labour_required) {
		this.labour_required = labour_required;
	}
	



}