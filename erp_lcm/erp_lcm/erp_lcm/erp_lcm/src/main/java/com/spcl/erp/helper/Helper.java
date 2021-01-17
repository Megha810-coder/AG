package com.spcl.erp.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Product;



public class Helper {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public static final String EMPLOYEE_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/emp_img/";
	public static final String CUSTOMER_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/cust_img/";
	public static final String PRODUCT_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/product_img/";
	public static final String SALEPERSON_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/saleperson_img/";
	public static final String LAB_IMG_PATH = "C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/lab_img/";
	public static final String CONT_IMG_PATH = "C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/cd_img/";
	public static final String EMP_EXCEl_PATH ="C:/Users/Dell/eclipse-workspace/erp_lcm/src/main/webapp/resources/emp_import_excel_file/";
	public static final String INCIDENT_DOC_PATH ="C:/Users/admin/Desktop/ERP FILE/erp_lcm/src/main/webapp/resources/incident_doc/";
	public static final String WASTE_DOC_PATH ="C:/Users/admin/Desktop/ERP FILE/erp_lcm/src/main/webapp/resources/waste_doc/";

	
	public static final Integer PO_RFQ=new Integer(1);
	public static final Integer PO_MAIL=new Integer(2);
	public static final Integer PO_ORDER=new Integer(3);
	
	public static final Integer TRA_DRAFT=new Integer(1);
	public static final Integer TRA_WATING=new Integer(2);
	public static final Integer TRA_READY=new Integer(3);
	public static final Integer TRA_DONE=new Integer(4);
	
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM/dd/yyyy");
	public static final SimpleDateFormat VIEWDATEFORMAT = new SimpleDateFormat("yyyy-mm-dd");
	
	public static final Integer To_APPROVE=new Integer(1);
	public static final Integer APPROVED=new Integer(2);
	public static final Integer REFUSE=new Integer(3);
	
	public static final String GENDER_FEMALE = "Female";
	public static final String GENDER_MALE = "Male";
	
	public static final String MARITAL_SINGLE="Single";
	public static final String MARITAL_MARRIED="Married";
	public static final String MARITAL_DIVORCE="Divorce";
	public static final String MARITAL_WIDWOE="Widowe";
	public static final String MARITAL_LEGAL_COHABITANT="Legal Cohabitant";
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public String getErrors(BindingResult result) {
		String error="";
		for (FieldError errorfile : result.getFieldErrors() ) {
	        error +=errorfile.getField()+ " - " + errorfile.getDefaultMessage()+"\n";
		 }
		 return error;
		
	}
	
	
	public String getContryDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select cntry_id,cntry_name from erp_country where cntry_flag=1 ORDER BY cntry_name asc";
		List coutry_list=null;
		try{
			Query query=session.createQuery(hql);
			coutry_list=query.list();
			tx.commit();
			List<Object[]> list = query.list();
			for(Object[] arr : list){
				return_value+="<option value='"+arr[0]+"'>"+arr[1]+"</option>/n";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}
	
	
	public JSONArray getCityDropDownJson(String city_name) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select city_id,city_name from erp_city where city_name like ? ORDER BY city_name asc";
		JSONArray returnjason=new JSONArray();
		List<Object[]> city_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(50);
			query.setString(0,city_name+"%");
			city_list=query.list();
			tx.commit();
			for(Object[] city : city_list){
				returnjason.put(new JSONObject().put("id",city[0]).put("text",city[1]));
			}
			return returnjason;
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
			return null;
		}
		

	}
	
	 public Customer getCustomerByName(String name) {

		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 String hql="from new_customer where c_active=1 and c_name=?";
		 Customer con=null;
//		 String intval=cd_fname;
		 try{
		 Query query=session.createQuery(hql);
		 query.setParameter(0,name);
		 con=(Customer)query.uniqueResult();
		 tx.commit();

		 }
		 catch(Exception e){
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }

		 return con;
		 }
	 
	 
	 public Product getProductByName(String name) {

		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 String hql="from product where p_active=1 and p_name=?";
		 Product pro=null;

		 try{
		 Query query=session.createQuery(hql);
		 query.setParameter(0,name);
		 pro=(Product)query.uniqueResult();
		 tx.commit();

		 }
		 catch(Exception e){
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }

		 return pro;
		 }

	 
	 public String getProductByHSN(String name) {

		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 String hql="select p_code from product where p_active=1 and p_name=?";
		 String hsn=null;

		 try{
		 Query query=session.createQuery(hql);
		 query.setParameter(0,name);
		 hsn=(String) query.uniqueResult();
		 tx.commit();

		 }
		 catch(Exception e){
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }

		 return hsn;
		 }
	 
	 public String getProductByUOM(String name) {

		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 String hql="select uom from product where p_active=1 and p_name=?";
		 String hsn=null;

		 try{
		 Query query=session.createQuery(hql);
		 query.setParameter(0,name);
		 hsn=(String) query.uniqueResult();
		 tx.commit();

		 }
		 catch(Exception e){
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }

		 return hsn;
		 }


	
	

}
