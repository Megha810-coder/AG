package com.spcl.erp.dao;

import java.sql.Date;
import java.util.List;

import com.spcl.erp.model.Bill;
import com.spcl.erp.model.CustReport;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product1;
import com.spcl.erp.model.ProductReport;
import com.spcl.erp.model.Product_details;
import com.spcl.erp.model.Vendor;

public interface ProductDao {
	
	public List<Product>getProduct();
	
	public boolean saveProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(String id);
	
	public List<Customer>getcustomer();
	
	public boolean saveCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
	public boolean deleteCustomer(String id);

	public List<Vendor> getVendor();

	public boolean saveVendor(Vendor vendor);

	public boolean updateVendor(Vendor vendor);
	
	public List<Customer> getCustomer(String data);

	public boolean deleteVender(String id);
	
	public List<Customer> getCustomer_list();
	
	public boolean getCustomer_name(String c_name);
	
	public List<Product> productData();
	
	public boolean saveProductD(Product_details product);
	
	public Long ProductCount();
	
	public Long CustomerCount();
	
	public Long VendorCount();
	
	public List<Product_details> getProductDetails(String id);
	
	public boolean saveProduct1(Product1 product);
	
	public Integer getBillNumber();
	
	public boolean saveBill(Bill bill);
	
	public boolean updateQuantity(int id,int quantity);
	
	public boolean saveProductReport(ProductReport prod);
	
	public List<ProductReport> getProductReport(String from, String to);
	
	public List<ProductReport> getProductReport1(String from, String to);
	//public List<ProductReport> getCustomerReport();
	
	public List<CustReport> custReport(int id, String from, String to);
	
	public boolean saveCr(CustReport cr);
	
	public List<CustReport> allcustReport(String from, String to);
	
	 public boolean checkProduct(Date date,String name);

	 public boolean updateProdQty(Date date1,String name,String quantity);
	 
	 public  List<Product> getQty();

	

	

}
