package com.spcl.erp.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Bill;
import com.spcl.erp.model.CustReport;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product1;
import com.spcl.erp.model.ProductReport;
import com.spcl.erp.model.Product_details;
import com.spcl.erp.model.Vendor;

public class ProductDaoImpl implements ProductDao{
	

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	private String tbl_product="product";
	private String tbl_customer = "new_customer";
	private String tbl_vendor ="new_vendor";
	private String tbl_product_report="product_report";

	@Override
	public List<Product> getProduct() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_product+" where p_active=1";
		List<Product> pro = new ArrayList<>();
 		List<Product> product_list=null;
		try{
			Query query=session.createQuery(hql);
			product_list=query.list();
			for(Product list : product_list ) {
				
					  int p_id = list.getP_id();
					  String p_name = list.getP_name();
					  String p_code = list.getP_code();
					  String p_brand = list.getP_brand();
					  Integer packages = list.getPackages();
					  Float rate = list.getRate();
					  String size = list.getSize();
					  String uom = list.getUom();
					 Integer quantity =list.getMin_quantity();
					 
					  
					  Product product = new Product(p_id,p_name,p_code,p_brand,packages,rate,size,uom,quantity);
					  pro.add(product);
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return product_list;
	}

	@Override
	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (product != null) {
			try {
				session.save(product);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (product != null) {
			try {
				session.update(product);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Customer> getcustomer() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_customer+" where c_active=1";
		List<Customer> customer = new ArrayList<>();
 		List<Customer> customer_list=null;
		try{
			Query query=session.createQuery(hql);
			customer_list=query.list();
			for(Customer list : customer_list ) {
				
					  int c_id = list.getC_id();
					  String c_name = list.getC_name();
					  String city = list.getCity();
					  String contact_no = list.getContact_no();
					  String email_id = list.getEmail_id();
					  String gst_no = list.getGst_no();
					  String note_of_add = list.getNote_of_add();
					  String add =list.getAddress();
					 
					  
					  Customer customer1 = new Customer(c_id,c_name,city,contact_no,email_id,gst_no,note_of_add,add);
					  customer.add(customer1);
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return customer_list;
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (customer != null) {
			try {
				session.save
				
				(customer);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (customer != null) {
			try {
				session.update(customer);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from " + tbl_customer + " WHERE c_id=" + id;
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from " + tbl_product + " WHERE p_id=" + id;
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Vendor> getVendor() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_vendor+" where v_active=1";
		List<Vendor> vendor = new ArrayList<>();
 		List<Vendor> vendor_list=null;
		try{
			Query query=session.createQuery(hql);
			vendor_list=query.list();
			for(Vendor list : vendor_list ) {
				
					  int v_id = list.getV_id();
					  String v_name = list.getV_name();
					  String conatct_no = list.getConatct_no();
					 // String Gst_no = list.getGst_no();
					  String address = list.getAddress();
					  String city = list.getCity();
					  String email_id = list.getEmail_id();
					  String website =list.getWebsite();
					  Float cgst =list.getCgst();
					  Float sgst =list.getSgst();
							  Float igst =	list.getIgst();	  
					 
					  
					  Vendor vendor1 = new Vendor(v_id,v_name,conatct_no,address,email_id,website,city,sgst,cgst,igst);
					  vendor.add(vendor1);
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return vendor_list;
	}

	@Override
	public boolean saveVendor(Vendor vendor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (vendor != null) {
			try {
				session.save
				
				(vendor);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (vendor != null) {
			try {
				session.update(vendor);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteVender(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from " + tbl_vendor + " WHERE v_id=" + id;
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> getCustomer_list() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select c_name from new_customer where c_active=1";
		 List<Customer> c_name_each = null;
		 try {
		 Query query = session.createQuery(hql);
		 c_name_each = query.list();
		
		 tx.commit();
		 session.close();
		 } catch (Exception e) {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }
		 return c_name_each;
	}

	@Override
	public boolean getCustomer_name(String name) {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select c_name from new_customer where c_name='"+name+"'";
		 List<Customer> c_name_each = null;
		 try {
		 Query query = session.createQuery(hql);
		 c_name_each = query.list();
		 System.out.println(c_name_each);
		 if(c_name_each.isEmpty()) {
			 return false;
		 }
		 tx.commit();
		 session.close();
		 return true;
		 } catch (Exception e) {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 return false;
		 }
		
	}

	@Override
	public List<Customer> getCustomer(String data) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "from new_customer where c_active=1 and c_name='"+data+"'";
		 List<Customer> customer = new ArrayList<>();
		 List<Customer> c_name_each = null;
		 try {
		 Query query = session.createQuery(hql);
		 c_name_each = query.list();
		 for(Customer list : c_name_each ) {
				
			  int c_id = list.getC_id();
			  String c_name = list.getC_name();
			  String city = list.getCity();
			  String contact_no = list.getContact_no();
			  String email_id = list.getEmail_id();
			  String gst_no = list.getGst_no();
			  String note_of_add = list.getNote_of_add();
			  String add =list.getAddress();
			 
			  Customer customer1 = new Customer(c_id,c_name,city,contact_no,email_id,gst_no,note_of_add,add);
			  customer.add(customer1);
	}
		 tx.commit();
		 session.close();
		 } catch (Exception e) {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }
		 return c_name_each;
	}

	@Override
	public List<Product> productData() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "from "+tbl_product+" where p_active=1";
		 List<Product> product= new ArrayList<>();
		 List<Product> p_name_each = null;
		 try {
			 Query query = session.createQuery(hql);
			 p_name_each = query.list();
			 for(Product list : p_name_each) {
				  String p_name = list.getP_name();
				  String uom = list.getUom();
				  Product prod = new Product(p_name,uom);
				  product.add(prod);
		}
			 tx.commit();
			 session.close();
			 } catch (Exception e) {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
			 }
			 return product;
	}

	@Override
	public Long ProductCount() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select count(p_name) from product where p_active=1";
		 Long p_name = null;
		 try {
			 Query query = session.createQuery(hql);
			 p_name = (Long)query.uniqueResult();
			 System.out.println("pname"+p_name);
			 tx.commit();
			 session.close();
			 } catch (Exception e) {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
			 }
		return p_name;
	}

	@Override
	public Long CustomerCount() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select count(c_name) from new_customer where c_active=1";
		 Long c_name = null;
		 try {
			 Query query = session.createQuery(hql);
			 c_name = (Long)query.uniqueResult();
			 tx.commit();
			 session.close();
			 } catch (Exception e) {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
			 }
		return c_name;
	}

	@Override
	public Long VendorCount() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select count(v_name) from new_vendor where v_active=1";
		 Long v_name = null;
		 try {
			 Query query = session.createQuery(hql);
			 v_name = (Long)query.uniqueResult();
			 tx.commit();
			 session.close();
			 } catch (Exception e) {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
			 }
		return v_name;
	}

	@Override
	public boolean saveProductD(Product_details product) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (product != null) {
			try {
				session.save(product);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Product_details> getProductDetails(String id) {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 int value = Integer.parseInt(id);
		 String hql = "from product_details where customer_c_id="+value;
		 List<Product_details> product = new ArrayList<>();
		 List<Product_details> product_each = null;
		 try {
		 Query query = session.createQuery(hql);
		 product_each = query.list();
		 System.out.print("prod"+product_each);
		 for(Product_details list : product_each) {
			  String pro_name = list.getPro_name();
			  float rate = list.getRate();
			  String HSN = list.getP_HSN();
			  String uom = list.getPro_uom();
			  Product_details prod = new Product_details(pro_name,rate,HSN,uom);
			  product.add(prod);
	}
		 tx.commit();
		 session.close();
		 } catch (Exception e) {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }
		 return product;
	}

	@Override
	public boolean saveProduct1(Product1 product) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (product != null) {
			try {
				session.save(product);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public Integer getBillNumber() {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "select max(b_number) from custreport where cr_active=1";
		 Integer no = null;
		 try {
			 Query query = session.createQuery(hql);
			 no = (Integer)query.uniqueResult();
			 tx.commit();
			 session.close();
			 } catch (Exception e) {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
			 }
		return no;
	}

	@Override
	public boolean saveBill(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (bill != null) {
			try {
				session.save(bill);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateQuantity(int id,int quantity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 String hql = "UPDATE product SET packages = '"+quantity+"' WHERE p_id = '"+id+ "'";
		if (id != 0 && quantity!= 0) {
			try {
				
				SQLQuery sqlQuery = session.createSQLQuery(hql);
				sqlQuery.executeUpdate();
				//session.update(product);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	
	//@Override
	public boolean saveProductReport(ProductReport prod) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (prod != null) {
			try {
				session.save(prod);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<ProductReport> getProductReport(String from, String to) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//String hql="select date,name,sum(quantity) from product_report where date>='"+from+"' and date<='"+to+"' group by name";
		String hql="from product_report where date>='"+from+"' and date<='"+to+"'"; 
		List<ProductReport> pro = new ArrayList<>();
 		List<ProductReport> product_list=null;
		try{
			Query query=session.createQuery(hql);
			product_list=query.list();
			for(ProductReport list : product_list ) {
				
				
					 // int pr_id = list.getPr_id();
					  Date pr_date = list.getDate();
					  long qty = list.getQuantity();
					  String name = list.getProduct().getP_name();
					  
					  
					  ProductReport product = new ProductReport(name,pr_date,qty);
					 
					  pro.add(product);
//					  for(ProductReport pro1 :pro) {
//						  
//					  }
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return pro;
	}

	
	@Override
	public List<ProductReport> getProductReport1(String from, String to) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//String hql="select pr_id,pr_active,date,name,sum(quantity) from product_report where date>='"+from+"' and date<='"+to+"' group by name";
		//String hql="from product_report where date>='"+from+"' and date<='"+to+"'"; 
		List<ProductReport> pro = new ArrayList<>();
 		List<ProductReport> product_list=null;
		try{
			Query query=session.createQuery("SELECT pr.name,SUM(pr.quantity) from product_report pr GROUP BY pr.name");
			product_list=query.list();
			for(ProductReport list : product_list ) {
				
				
					  int pr_id = list.getPr_id();
					  Date pr_date = list.getDate();
					  long qty = list.getQuantity();
					  String name = list.getProduct().getP_name();
					  
					  
					  ProductReport product = new ProductReport(name,pr_date,qty);
					 
					  pro.add(product);
//					  for(ProductReport pro1 :pro) {
//						  
//					  }
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return pro;
	}

	
		@Override
		public List<CustReport> custReport(int id, String from, String to) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			String hql="from custreport where date>='"+from+"' and date<='"+to+"' and customer_c_id="+id;
			List<CustReport> pro = new ArrayList<>();
			 	 List<CustReport> product_list=null;
			 	 
			try{
			Query query=session.createQuery(hql);
			product_list=query.list();
 			for(CustReport list : product_list ) {
			System.out.println(list);
			
			int number = list.getB_number();
			float cgst = list.getCgst();
			String date = list.getDate();
			float grossamt= list.getGrossamt();
			float gstamt1 = list.getGstamt1();
			int igst = list.getIgst();
			float netamt = list.getNetamt();
			float sgst = list.getSgst();
			String name  = list.getCustomer().getC_name();
			String GST = list.getCustomer().getGst_no();
			String add = list.getCustomer().getAddress();

			
			CustReport bill = new CustReport(number,igst,cgst,date,grossamt,gstamt1,netamt,sgst,name,GST,add);
			pro.add(bill);
			}
			tx.commit();
			session.close();
			}
			catch(Exception e)
			{
			tx.rollback();
			session.close();
			e.printStackTrace();
			}
			return pro;
			}

		@Override
		public boolean saveCr(CustReport cr) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			if (cr != null) {
				try {
					session.save(cr);
					tx.commit();
					session.close();
					return true;
				} catch (Exception e) {
					tx.rollback();
					session.close();
					e.printStackTrace();
					return false;
				}
			}
			return false;
		}

		@Override
		public List<CustReport> allcustReport(String from, String to) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			String hql="from custreport where date>='"+from+"' and date<='"+to+"'";
			List<CustReport> pro = new ArrayList<>();
			 	 List<CustReport> product_list=null;
			 	 
			try{
			Query query=session.createQuery(hql);
			product_list=query.list();
 			for(CustReport list : product_list ) {
			System.out.println(list);
			
			int number = list.getB_number();
			float cgst = list.getCgst();
			String date = list.getDate();
			float grossamt= list.getGrossamt();
			float gstamt1 = list.getGstamt1();
			int igst = list.getIgst();
			float netamt = list.getNetamt();
			float sgst = list.getSgst();
			String name  = list.getCustomer().getC_name();
			String GST = list.getCustomer().getGst_no();
			String add = list.getCustomer().getAddress();

			
			CustReport bill = new CustReport(number,igst,cgst,date,grossamt,gstamt1,netamt,sgst,name,GST,add);
			pro.add(bill);
			}
			tx.commit();
			session.close();
			}
			catch(Exception e)
			{
			tx.rollback();
			session.close();
			e.printStackTrace();
			}
			return pro;
		}

//		@Override
//		public List<ProductReport> getCustomerReport() {
//			// TODO Auto-generated method stub
//			return null;
//		}

		@Override
		public boolean checkProduct(Date date, String name) {
		//return false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from product_report where date='"+date+"' and name='"+name+"'"; 
		List<ProductReport> pro = new ArrayList<>();
		 	 List<ProductReport> product_list=null;
		try{
		Query query=session.createQuery(hql);
		product_list=query.list();

		if(!product_list.isEmpty()) {
		return true;
		}
		else
		{
		return false;

		}
		//tx.commit();
		//session.close();
		//session.close();
		}
		catch(Exception e)
		{
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}
		
		@Override
		public boolean updateProdQty(Date date1, String name, String quantity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 String hql = "update product_report set quantity=quantity+"+quantity+" where date='"+date1+"' and name='"+name+"'";
		//if (id != 0 && quantity!= 0) {
		try {

		SQLQuery sqlQuery = session.createSQLQuery(hql);
		sqlQuery.executeUpdate();
		//session.update(product);
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		return false;
		}
		//}
		//return false;
		}

		@Override
		public List<Product> getQty() {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			String hql="from product where p_active=1";
			List<Product> pro = new ArrayList<>();
			 	 List<Product> product_list=null;
			 	 
			try{
			Query query=session.createQuery(hql);
			product_list=query.list();
 			for(Product list : product_list ) {
			System.out.println(list);
			
			int minqty= list.getMin_quantity();
			int packages =list.getPackages();
			String name= list.getP_name();
			
			
			Product bill = new Product(minqty,packages,name);
			pro.add(bill);
			}
			tx.commit();
			session.close();
			}
			catch(Exception e)
			{
			tx.rollback();
			session.close();
			e.printStackTrace();
			}
			return pro;
		}

	
	

	
}
