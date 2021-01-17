package com.spcl.erp.services;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.spcl.erp.dao.ProductDao;
import com.spcl.erp.model.Bill;
import com.spcl.erp.model.CustReport;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product1;
import com.spcl.erp.model.ProductReport;
import com.spcl.erp.model.Product_details;
import com.spcl.erp.model.Vendor;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public boolean saveProduct(Product product) {
		return productDao.saveProduct(product);
	}


	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}


	@Override
	public List<Customer> getcustomer() {
		return productDao.getcustomer();
	}


	@Override
	public boolean saveCustomer(Customer customer) {
		return productDao.saveCustomer(customer);
	}


	@Override
	public boolean updateCustomer(Customer customer) {
		return productDao.updateCustomer(customer);
	}


	@Override
	public boolean deleteCustomer(String id) {
		return productDao.deleteCustomer(id);
	}


	@Override
	public boolean deleteProduct(String id) {
		return productDao.deleteProduct(id);
	}


	@Override
	public List<Vendor> getVendor() {
		return productDao.getVendor();
	}


	@Override
	public boolean saveVendor(Vendor vendor) {
		return productDao.saveVendor(vendor);
	}


	@Override
	public boolean updateVendor(Vendor vendor) {
		return productDao.updateVendor(vendor);
	}


	@Override
	public boolean deleteVender(String id) {
		return productDao.deleteVender(id);
	}


	@Override
	public List<Customer> getCustomer_list() {
		return productDao.getCustomer_list();
	}


	@Override
	public boolean getCustomer_name(String c_name) {
		return productDao.getCustomer_name(c_name);
	}


	@Override
	public List<Customer> getCustomer(String data) {
		return productDao.getCustomer(data);
	}


	@Override
	public List<Product> getProduct() {
		return productDao.getProduct();
	}


	@Override
	public List<Product> productData() {
		return productDao.productData();
	}
	
	
	@Override
	public Long ProductCount() {
		return productDao.ProductCount();
	}

	@Override
	public Long CustomerCount() {
		return productDao.CustomerCount() ;
	}

	@Override
	public Long VendorCount() {
		return productDao.VendorCount();
	}

	@Override
	public boolean saveProductD(Product_details product) {
		return productDao.saveProductD(product);
	}

	@Override
	public List<Product_details> getProductDetails(String id) {
		return productDao.getProductDetails(id);
	}

	@Override
	public boolean saveProduct1(Product1 product) {
		return productDao.saveProduct1(product);
	}

	@Override
	public Integer getBillNumber() {
		return productDao.getBillNumber();
	}

	@Override
	public boolean saveBill(Bill bill) {
		
		return productDao.saveBill(bill);
	}

	@Override
	public boolean updateQuantity(int id, int quantity) {
		return productDao.updateQuantity(id, quantity);
	}

	@Override
	public boolean saveProductReport(ProductReport prod) {
		return productDao.saveProductReport(prod);
	}

	@Override
	public List<ProductReport> getProductReport(String from, String to) {
		return productDao.getProductReport(from,to);
	}
	
	@Override
	public List<ProductReport> getProductReport1(String from, String to) {
		return productDao.getProductReport1(from,to);
	}

//	@Override
//	public List<ProductReport> getCustomerReport() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<CustReport> custReport(int id, String from, String to) {
		return productDao.custReport(id, from, to);
	}

	@Override
	public boolean saveCr(CustReport cr) {
		return  productDao.saveCr(cr);
	}

	@Override
	public List<CustReport> allcustReport(String from, String to) {
		return productDao.allcustReport(from, to);
	}
	
	@Override
	public boolean checkProduct(Date date, String name) {
	return productDao.checkProduct(date, name);
	}

	@Override
	public boolean updateProdQty(Date date1, String name, String quantity) {
	return productDao.updateProdQty(date1, name, quantity);
	}

	@Override
	public List<Product> getQty() {
		// TODO Auto-generated method stub
		return  productDao.getQty();
	}


	
	

}
