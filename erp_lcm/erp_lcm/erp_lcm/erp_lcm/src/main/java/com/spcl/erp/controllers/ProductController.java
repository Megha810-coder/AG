package com.spcl.erp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Bill;
import com.spcl.erp.model.CustReport;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product1;
import com.spcl.erp.model.ProductReport;
import com.spcl.erp.model.Product_details;
import com.spcl.erp.model.Vendor;
import com.spcl.erp.services.HrRequirementService;
import com.spcl.erp.services.ProductService;

@Controller
@RequestMapping(value = "/bill")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Helper helper;
	
	JSONObject json = new JSONObject();
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_product", method = RequestMethod.GET)
	public String manageProduct(Locale locale, Model model,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		List<Product> product_list=new ArrayList<Product>();
		product_list=productService.getProduct();


		PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        Gson json = new Gson();
		        String Json=null;
		        if(product_list.size()>0) {
		        	  Json=json.toJson(product_list);
		        	 System.out.print("ProductData"+Json);
		        }		       
		        model.addAttribute("Json", Json);
		model.addAttribute("url", request.getRequestURI());
		return "bill/mng_product";
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/save_product", method = RequestMethod.POST)
	 public void save_product(
	 @ModelAttribute("data") @Valid Product product, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	        
	         String p_brand = jsonObj.getString("p_brand");
	         product.setP_brand(p_brand);
	         
	         String p_code = jsonObj.getString("p_code");
	         product.setP_code(p_code);
	         
	         String p_name = jsonObj.getString("p_name");
	         product.setP_name(p_name);
	         
	         String packages = jsonObj.getString("packages");
	         Integer packages1 = Integer.parseInt(packages);
	         product.setPackages(packages1);
	         
	         String rate = jsonObj.getString("rate");
	         Float rate1 = Float.parseFloat(rate);
	         product.setRate(rate1);
	         
//	         String size = jsonObj.getString("size");
//	         product.setSize(size);
	         
	         String uom = jsonObj.getString("uom");
	         product.setUom(uom);
	         
//	         String min_quantity = jsonObj.getString("min_quantity");
//	         Integer min_quantity1 = Integer.parseInt(min_quantity);
//	         product.setMin_quantity(min_quantity1);
	         
	     	 product.setP_active("1");
	     	 
	 boolean flag3 =productService.saveProduct(product);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }
	
	
	@CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/update_product", method = RequestMethod.POST)
	 public void update_product(
	 @ModelAttribute("data") @Valid Product product, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	         
	         Integer id = (Integer) jsonObj.get("p_id");
	         product.setP_id(id);
	        
	         String p_brand = jsonObj.getString("p_brand");
	         product.setP_brand(p_brand);
	         
	         String p_code = jsonObj.getString("p_code");
	         product.setP_code(p_code);
	         
	         String p_name = jsonObj.getString("p_name");
	         product.setP_name(p_name);
	         
	         String packages = jsonObj.getString("packages");
	         Integer packages1 = Integer.parseInt(packages);
	         product.setPackages(packages1);
	         
	        // Float rate2 = (Float) jsonObj.get("rate");
	         String rate = jsonObj.getString("rate");
	         Float rate1 = Float.parseFloat(rate);
	         product.setRate(rate1);
	         
//	         String size = jsonObj.getString("size");
//	         product.setSize(size);
	         
	         String uom = jsonObj.getString("uom");
	         product.setUom(uom);
	         
//	         String min_quantity = jsonObj.getString("min_quantity");
//	         Integer min_quantity1 = Integer.parseInt(min_quantity);
//	         product.setMin_quantity(min_quantity1);
	         
	     	 product.setP_active("1");
	     	 
	 boolean flag3 =productService.updateProduct(product);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }
	
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_product", method = RequestMethod.GET)
	    public void delete_product(
	    		HttpServletRequest request,
	    		HttpServletResponse response
	    	) {
			String msg="false";
			String id=request.getParameter("p_id").trim();
			boolean value = productService.deleteProduct(id);
			if(value) {
				msg="true";
			}
		
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
			response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	 		try {
	 			response.getWriter().write(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
	    }
	

	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_customer", method = RequestMethod.GET)
	public void mng_customer(Locale locale, Model model,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		List<Customer> customer_list=new ArrayList<Customer>();
		customer_list=productService.getcustomer();
		System.out.println(customer_list);

		        PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        Gson json = new Gson();
		        String Json=null;
		        if(customer_list.size()>0) {
		        	  Json=json.toJson(customer_list);
		        	 out.print(Json);
		        }		       
		        model.addAttribute("Json", Json);
		model.addAttribute("url", request.getRequestURI());
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/save_customer", method = RequestMethod.POST)
	 public void save_customer(
	 @ModelAttribute("data") @Valid Customer customer, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
//	         String product=request.getParameter("checkedRoles");
//	         System.out.println(product); 
	         
	         
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	         
	       
	         String c_name = jsonObj.getString("c_name");
	         customer.setC_name(c_name);
	         
	         String contact_no = jsonObj.getString("contact_no");
	         customer.setContact_no(contact_no);
	         
	         String gst_no = jsonObj.getString("gst_no");
	         customer.setGst_no(gst_no);
	         
	         String address = jsonObj.getString("address");
	         customer.setAddress(address);
	         
	         String city = jsonObj.getString("city");
	         customer.setCity(city);
	         
	         String email_id = jsonObj.getString("email_id");
	         customer.setEmail_id(email_id);
	         
	         String note_of_add = jsonObj.getString("note_of_add");
	         customer.setNote_of_add(note_of_add);
	         
	JSONArray ClassDetails = jsonObj.getJSONArray("ClassDetails");
			 System.out.println(ClassDetails);
			 ClassDetails.get(0);
			//JSONArray value = lineItems.getJSONArray(0);
			// System.out.println("value"+value);
				       
	        // JSONObject product = json.getJSONObject("product");
	       
	        // System.out.print("product"+product);
	        // String products = product.getString("")
	         
	         
	     	customer.setC_active("1");
	     	 
	 boolean flag3 =productService.saveCustomer(customer);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }
	
	
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/update_customer", method = RequestMethod.POST)
	 public void update_customer(
	 @ModelAttribute("data") @Valid Customer customer, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	         
	         Integer c_id = (Integer) jsonObj.get("c_id");
	         customer.setC_id(c_id);
	        
	         String c_name = jsonObj.getString("c_name");
	         customer.setC_name(c_name);
	         
	         String contact_no = jsonObj.getString("contact_no");
	         customer.setContact_no(contact_no);
	         
	         String Gst_no = jsonObj.getString("Gst_no");
	         customer.setGst_no(Gst_no);
	         
	         String address = jsonObj.getString("address");
	         customer.setAddress(address);
	         
	         String city = jsonObj.getString("city");
	         customer.setCity(city);
	         
	         String email_id = jsonObj.getString("email_id");
	         customer.setEmail_id(email_id);
	         
	         String note_of_add = jsonObj.getString("note_of_add");
	         customer.setNote_of_add(note_of_add);
	         

		        
	     	customer.setC_active("1");
	     	 
	 boolean flag3 =productService.updateCustomer(customer);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }
	
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_customer", method = RequestMethod.GET)
	    public void delete_customer(
	    		HttpServletRequest request,
	    		HttpServletResponse response
	    	) {
			String msg="false";
			String id=request.getParameter("c_id").trim();
			boolean value = productService.deleteCustomer(id);
			if(value) {
				msg="true";
			}
		
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
			response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	 		try {
	 			response.getWriter().write(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
	    }
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/mng_vendor", method = RequestMethod.GET)
		public void mng_vendor(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
			List<Vendor> vendor_list=new ArrayList<Vendor>();
			vendor_list=productService.getVendor();


			        PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(vendor_list.size()>0) {
			        	  Json=json.toJson(vendor_list);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}
		
	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/save_vendor", method = RequestMethod.POST)
	 public void save_vendor(
	 @ModelAttribute("data") @Valid Vendor vendor, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	        
	         String v_name = jsonObj.getString("v_name");
	         vendor.setV_name(v_name);
	         
	         String conatct_no = jsonObj.getString("conatct_no");
	         vendor.setConatct_no(conatct_no);
	         
	         String gst_no = jsonObj.getString("gst_no");
	         vendor.setGst_no(gst_no);
	         
	         String address = jsonObj.getString("address");
	         vendor.setAddress(address);
	         
	         String city = jsonObj.getString("city");
	         vendor.setCity(city);
	         
	         String email_id = jsonObj.getString("email_id");
	         vendor.setEmail_id(email_id);
	         
	         String website = jsonObj.getString("website");
	         vendor.setWebsite(website);
	         
	         String cgst = jsonObj.getString("cgst");
	         Float cgst1 = Float.parseFloat(cgst);
	         vendor.setCgst(cgst1);
	         
	         String sgst = jsonObj.getString("sgst");
	         Float sgst1 = Float.parseFloat(sgst);
	         vendor.setSgst(sgst1);
	         
	         String igst = jsonObj.getString("igst");
	         Float igst1 = Float.parseFloat(igst);
	         vendor.setIgst(igst1);
	         
	        
	         
	     	vendor.setV_active(1);
	     	 
	 boolean flag3 =productService.saveVendor(vendor);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }

	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/update_vendor", method = RequestMethod.POST)
	 public void update_vendor(
	 @ModelAttribute("data") @Valid Vendor vendor, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	        
	         Integer v_id = (Integer) jsonObj.get("v_id");
	         vendor.setV_id(v_id);
	         
	         String v_name = jsonObj.getString("v_name");
	         vendor.setV_name(v_name);
	         
	         String conatct_no = jsonObj.getString("conatct_no");
	         vendor.setConatct_no(conatct_no);
	         
	         String gst_no = jsonObj.getString("gst_no");
	         vendor.setGst_no(gst_no);
	         
	         String address = jsonObj.getString("address");
	         vendor.setAddress(address);
	         
	         String city = jsonObj.getString("city");
	         vendor.setCity(city);
	         
	         String email_id = jsonObj.getString("email_id");
	         vendor.setEmail_id(email_id);
	         
	         String website = jsonObj.getString("website");
	         vendor.setWebsite(website);
	         
		
			  String cgst = jsonObj.getString("cgst"); 
			  Float cgst1 =Float.parseFloat(cgst);
			  vendor.setCgst(cgst1);
		 
	         
	         String sgst = jsonObj.getString("sgst");
	         Float sgst1 = Float.parseFloat(sgst);
	         vendor.setSgst(sgst1);
	         
	         String igst = jsonObj.getString("igst");
	         Float igst1 = Float.parseFloat(igst);
	         vendor.setIgst(igst1);
	         
	        
	         
	     	vendor.setV_active(1);
	     	 
	 boolean flag3 =productService.updateVendor(vendor);
	 

	 response.getWriter().write(json.toString());
	 return;

	     }

	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_vendor", method = RequestMethod.GET)
	    public void delete_vendor(
	    		HttpServletRequest request,
	    		HttpServletResponse response
	    	) {
			String msg="false";
			String id=request.getParameter("v_id").trim();
			boolean value = productService.deleteVender(id);
			if(value) {
				msg="true";
			}
		
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
			response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	 		try {
	 			response.getWriter().write(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
	    }
	 
	 
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/customer_list", method = RequestMethod.GET)
		public void customer_list(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
			List<Customer> customer_list=new ArrayList<Customer>();
			customer_list=productService.getCustomer_list();


			        PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(customer_list.size()>0) {
			        	  Json=json.toJson(customer_list);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}
	 
	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/c_name", method = RequestMethod.POST)
	 public String c_name(
	 @ModelAttribute("data") @Valid Vendor vendor, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	        
	         String c_name = jsonObj.getString("name");
	         System.out.println(c_name);

	         boolean flag3 =productService.getCustomer_name(c_name);
	 System.out.println(flag3);
	 PrintWriter out = response.getWriter();
     response.setContentType("application/json");
     response.setCharacterEncoding("UTF-8");
     Gson json = new Gson();
     String Json=null;
    
     	  Json=json.toJson(flag3);
     	 out.print(Json);
    	       
     model.addAttribute("Json", Json);
	 

	 response.getWriter().write(json.toString());
	 return "bill/c_name";

	     }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/customer_data", method = RequestMethod.GET)
	    public void customer_data(
	    		HttpServletRequest request,
	    		HttpServletResponse response,
	    		 ModelMap model
	    	) throws IOException {
			String data=request.getParameter("value");
			System.out.println("data is = "+data);
			
			List<Customer> customer_list=new ArrayList<Customer>();
			customer_list=productService.getCustomer(data);
			System.out.println(customer_list);
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        
	        if(customer_list.size()>0) {
	        	  Json=json.toJson(customer_list);
	        	 out.print(Json);
	        }	
	        
	        model.addAttribute("Json", Json);
	    }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/product", method = RequestMethod.GET)
	    public void product(
	    		HttpServletRequest request,
	    		HttpServletResponse response,
	    		 ModelMap model
	    	) throws IOException {
			
			List<Product> product_list=new ArrayList<Product>();
			product_list=productService.productData();	
			System.out.println(product_list);
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        
	        if(product_list.size()>0) {
	        	  Json=json.toJson(product_list);
	        	 out.print(Json);
	        }	
	        
	        model.addAttribute("Json", Json);
	    }
	 
	 
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/product_count", method = RequestMethod.GET)
		public void product_count(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
		
		 Long product_cnt=(Long) productService.ProductCount();

			PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(product_cnt>0) {
			        	  Json=json.toJson(product_cnt);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}

	 
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/customer_count", method = RequestMethod.GET)
		public void customer_count(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
		
		 Long customer_count=(Long) productService.CustomerCount();

			PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(customer_count>0) {
			        	  Json=json.toJson(customer_count);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}
	 
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/vendors_count", method = RequestMethod.GET)
		public void vendors_count(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
		
		 Long vendor_count=(Long) productService.VendorCount();

			PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(vendor_count>0) {
			        	  Json=json.toJson(vendor_count);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}

	 
	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/product_details", method = RequestMethod.POST)
	 public void product_details(
	 @ModelAttribute("data") @Valid Customer customer, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }

	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	         
	         Product_details product = new Product_details();
	         String c_name = jsonObj.getString("c_name");
	         Customer cust = helper.getCustomerByName(c_name);
	         if(cust!=null)
	         {
	        	 product.setCustomer(cust);
		         //customer.setC_name(c_name);
	         }
	         else {
	        	 customer.setC_name(c_name);
	        	  
	        	  String contact_no = jsonObj.getString("contact_no");
	 	         customer.setContact_no(contact_no);
	 	         
	 	         String gst_no = jsonObj.getString("gst_no");
	 	         customer.setGst_no(gst_no);
	 	         
	 	         String address = jsonObj.getString("address");
	 	         customer.setAddress(address);
	 	         
	 	         String city = jsonObj.getString("city");
	 	         customer.setCity(city);
	 	         
	 	         String email_id = jsonObj.getString("email_id");
	 	         customer.setEmail_id(email_id);
	 	         
	 	         String note_of_add = jsonObj.getString("note_of_add");
	 	         customer.setNote_of_add(note_of_add);
	 	         
	 	        customer.setC_active("1");
	 	         
	 	        boolean flag3 =productService.saveCustomer(customer);
	 	        
	         }
	         String rate ="";
	         
	       
	      
	         JSONArray ClassDetails = jsonObj.getJSONArray("ClassDetails");

	         for (int i = 0; i < ClassDetails.length(); ++i) {
	        	    JSONObject rec = ClassDetails.getJSONObject(i);
	        	    System.out.println("rec"+rec);
	        	    
	        	    try {
	        	     rate = rec.getString("rate");
	        	    float rate1= Float.parseFloat(rate);
	        	    product.setRate(rate1);
	        	    }
	        	    catch(Exception e) {
	        	    	continue;
	        	    
	        	    }
	        	    try {
	        	    	  int packages = rec.getInt("package");
		        	    product.setPackages(packages);
		        	    }
		        	    catch(Exception e) {
		        	    	continue;
		        	    
		        	    }
	        	    
	        	    
	        	    try {
	        	    	  int size = rec.getInt("size");
		        	    product.setSize(size);
		        	    }
		        	    catch(Exception e) {
		        	    	continue;
		        	    }
	        	    
	        	    try {
	        	    	  int qty = rec.getInt("qty");
		        	    product.setQuantity(qty);
		        	    }
		        	    catch(Exception e) {
		        	    	continue;
		        	    
		        	    }
	        	    
	        	    
	        	    try {
	        	    	 String class1 = rec.getString("Class");
	        	    	 product.setPro_name(class1);
	        	    	 Product pro1 = helper.getProductByName(class1);
	        	    	 product.setProduct(pro1);
		        	    }
		        	    catch(Exception e) {
		        	    	continue;
		        	    
		        	    }
	        	    
	        	    try {
	        	    	  int box = rec.getInt("box");
		        	    product.setBox(box);
		        	    }
		        	    catch(Exception e) {
		        	    	continue;
		        	    
		        	    }
	        	    Customer cust1 = helper.getCustomerByName(c_name);
	  	 	      product.setCustomer(cust1);
	        	    if(!rate.equals("")) {
	        	    boolean flag3 =productService.saveProductD(product);
	        		 System.out.println("flag3"+flag3);
	        	    }
	        	  
	        	}
	 response.getWriter().write(json.toString());
	 return;

	     }
	 
	 @CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/save", method = RequestMethod.GET)
		public void save(Locale locale, Model model,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
		 
		 String id=request.getParameter("value");
		 System.out.println("id="+id);
			List<Product_details> product=new ArrayList<Product_details>();
			product=productService.getProductDetails(id);


			PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			        if(product.size()>0) {
			        	  Json=json.toJson(product);
			        	 out.print(Json);
			        }		       
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
		}
		
	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/save_contract", method = RequestMethod.POST)
	 public void save_contract(
	 @ModelAttribute("data") @Valid Customer cust, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response
	
	  )throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	        
	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	        
	         String name = jsonObj.getString("name");
	         cust.setC_name(name);
	         
	         String contact = jsonObj.getString("contact");
	         cust.setContact_no(contact);
	         
	         String emailid = jsonObj.getString("emailid");
	         cust.setEmail_id(emailid);
	         
	         String gst = jsonObj.getString("gst");
	         cust.setGst_no(gst);
	         
	         String address = jsonObj.getString("address");
	         cust.setAddress(address);
	         
	         cust.setC_active("1");
	         
	        
	         
	 boolean flag3 =productService.saveCustomer(cust);
	 
	  String rate ="";
      
      
      Product_details product = new Product_details();
      JSONArray ClassDetails = jsonObj.getJSONArray("ClassDetails");

      for (int i = 0; i < ClassDetails.length(); ++i) {
     	    JSONObject rec = ClassDetails.getJSONObject(i);
     	    System.out.println("rec"+rec);
     	    
     	    try {
     	     rate = rec.getString("rate");
     	    float rate1= Float.parseFloat(rate);
     	    product.setRate(rate1);
     	    }
     	    catch(Exception e) {
     	    	continue;
     	    
     	    }
     	   
     	    try {
     	    	 String class1 = rec.getString("Class");
     	    	 product.setPro_name(class1);
     	    	 Product pro1 = helper.getProductByName(class1);
     	    	 product.setProduct(pro1);
     	    	 product.setPd_active("1");
     	    	 String code = helper.getProductByHSN(class1);
     	    	 product.setP_HSN(code);
     	    	 String uom= helper.getProductByUOM(class1);
     	    	 product.setPro_uom(uom);
     	    	 
	        	    }
	        	    catch(Exception e) {
	        	    	continue;
	        	    
	        	    }
     	    
     	    
     	    Customer cust1 = helper.getCustomerByName(name);
	 	      product.setCustomer(cust1);
     	    if(!rate.equals("")) {
     	    boolean flag31 =productService.saveProductD(product);
     		 System.out.println("flag31"+flag31);
     	    }
     	  
     	}
	 

	 response.getWriter().write(json.toString());
	 return;

	     }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
		@RequestMapping(value = "/bill", method = RequestMethod.GET)
		public void bill(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
				throws IOException {

		 Integer count =(Integer) productService.getBillNumber();
		 System.out.println("count="+count);
		 	if(count==null) {
		 		count=0;
		 	}
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Gson json = new Gson();
			String Json = null;
		if (count >= 0) {
			Json = json.toJson(count);
			out.print(Json);
			}
//			model.addAttribute("Json", Json);
//			model.addAttribute("helper", helper);
//			model.addAttribute("labourService", labourService);
//			model.addAttribute("url", request.getRequestURI());
//			return "labour/Con_count";
		}
	 
	 @CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/save_contract1", method = RequestMethod.POST)
			 public void save_contract1(
			 @ModelAttribute("data") @Valid Customer cust, 
			 BindingResult result,
			 ModelMap model,
			 HttpServletRequest request, 
			 HttpServletResponse response)

			  throws IOException {

			 response.setContentType("application/json");
			         response.setCharacterEncoding("UTF-8");
			         json=new JSONObject();
			        
			         String data = "";   
			         StringBuilder builder = new StringBuilder();
			         BufferedReader reader = request.getReader();
			         String line;
			         while ((line = reader.readLine()) != null) {
			             builder.append(line);
			         }
			         data = builder.toString();
			         System.out.println(data);
			         JSONObject jsonObj = new JSONObject(data);
			         System.out.println(jsonObj);
			        
			         String name = jsonObj.getString("name");
			         //cust.setC_name(name);
			         
			        
			       //  cust.setC_active("1";
			         
			        
			         
			// boolean flag3 =productService.saveCustomer(cust);
			 
			  String rate ="";
			      
			      
			      Product_details product = new Product_details();
			      JSONArray ClassDetails = jsonObj.getJSONArray("ClassDetails");

			      for (int i = 0; i < ClassDetails.length(); ++i) {
			     	    JSONObject rec = ClassDetails.getJSONObject(i);
			     	    System.out.println("rec"+rec);
			     	    
			     	    try {
			     	     rate = rec.getString("rate");
			     	    float rate1= Float.parseFloat(rate);
			     	    product.setRate(rate1);
			     	    }
			     	    catch(Exception e) {
			     	    	continue;
			     	    
			     	    }
			     	   
			     	    try {
			     	    	 String class1 = rec.getString("Class");
			     	    	 product.setPro_name(class1);
			     	    	 product.setPd_active("1");
			     	    	 Product pro1 = helper.getProductByName(class1);
			     	    	 product.setProduct(pro1);
			     	    	 String code = helper.getProductByHSN(class1);
			     	    	 product.setP_HSN(code);
			     	    	 String uom =helper.getProductByUOM(class1);
			     	    	 product.setPro_uom(uom);
			        	    }
			        	    catch(Exception e) {
			        	    	continue;
			        	    
			        	    }
			     	    
			     	    
			     	    Customer cust1 = helper.getCustomerByName(name);
			 	      product.setCustomer(cust1);
			     	    if(!rate.equals("")) {
			     	    boolean flag31 =productService.saveProductD(product);
			     	  System.out.println("flag31"+flag31);
			     	    }
			     	  
			     	}
			 

			 response.getWriter().write(json.toString());
			 return;

			     }
	 
	 @CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/save_bill", method = RequestMethod.POST)
			 public void save_bill(
			 @ModelAttribute("mergedata2") @Valid Bill bill, 
			 BindingResult result,
			 ModelMap model,
			 HttpServletRequest request, 
			 HttpServletResponse response)

			  throws IOException {

			 response.setContentType("application/json");
			         response.setCharacterEncoding("UTF-8");
			         json=new JSONObject();
			        
			         String data = "";   
			         StringBuilder builder = new StringBuilder();
			         BufferedReader reader = request.getReader();
			         String line;
			         while ((line = reader.readLine()) != null) {
			             builder.append(line);
			         }
			         data = builder.toString();
			         System.out.println(data);
			         JSONObject jsonObj = new JSONObject(data);
			         System.out.println(jsonObj);
			         
			         String name = jsonObj.getString("name");
			         Customer cust = helper.getCustomerByName(name);
			         bill.setCustomer(cust);
			         System.out.println("name="+name);
			         
			         Integer bill_no = (Integer) jsonObj.get("bill_no");
			         //Integer no = Integer.parseInt(bill_no);
			         bill.setB_number(bill_no);
			         System.out.println("bill_no="+bill_no);
			         
			         String date = jsonObj.getString("date");
			         bill.setDate(date);
			         System.out.println("date="+date);
			         
			         String grossamt = (String) jsonObj.get("grossamt");
			         Float gross1 = Float.parseFloat(grossamt);
			         bill.setGrossamt(gross1);
			         System.out.println("grossamt="+grossamt);
			         
			         String cgst = (String) jsonObj.get("cgst");
			         Float cgst1 = Float.parseFloat(cgst);
			         bill.setCgst(cgst1);
			         System.out.println("cgst="+cgst);
			         
			         String sgst = (String) jsonObj.get("sgst");
			         Float sgst1 = Float.parseFloat(sgst);
			         bill.setSgst(sgst1);
			         System.out.println("sgst="+sgst);
			         
			         Integer igst = (Integer) jsonObj.get("igst");
			         bill.setIgst(igst);
			         System.out.println("igst="+igst);
			         
			         String gstamount = (String) jsonObj.get("gstamount");
			         Float gstamount1 = Float.parseFloat(gstamount);
			         bill.setGstamt1(gstamount1);
			         System.out.println("gstamount1="+gstamount1);
			         
			         String netamt = (String) jsonObj.get("netamt");
			         Float netamt1 = Float.parseFloat(netamt);
			         bill.setNetamt(netamt1);
			         System.out.println("netamt1="+netamt1);
			         
			         CustReport cr = new CustReport();
			         cr.setB_number(bill_no);
			         cr.setDate(date);
			         cr.setGrossamt(gross1);
			         cr.setCgst(cgst1);
			         cr.setSgst(sgst1);
			         cr.setIgst(igst);
			         cr.setGstamt1(gstamount1);
			         cr.setNetamt(netamt1);
			         cr.setCr_active(1);
			         cr.setCustomer(cust);
			         productService.saveCr(cr);
			         
			         String arr1[]= {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
			        	   "21","22","23","24","25","26","27","28","29","30"};
			         for (int i = 0; i < arr1.length; i++) {
			        	 
			        	   String arr=arr1[i];
			        	   try {
			        	 JSONObject search = (JSONObject) jsonObj.get(arr);
			  	         System.out.println("search="+search);
			  	         
			  	         String ans3 = search.getString("ans3");
			  	         Float ans31 = Float.parseFloat(ans3);
			  	         bill.setAmount(ans31);
			  	         System.out.println("ans31="+ans31);
			  	         
			  	         
			  	         String ans2 = search.getString("ans2");
			  	         Float ans21 = Float.parseFloat(ans2);
			  	         bill.setGstAmount(ans21);
			  	         System.out.println("ans2="+ans21);
			  	         
			  	         String total = search.getString("total");
			  	         Float total1 = Float.parseFloat(total);
			  	         bill.setTotal(total1);
			  	         System.out.println("total="+total);
			  	         
			  	         String name1 = search.getString("name");
			  	         Product prod = helper.getProductByName(name1);
			  	         bill.setProduct(prod);
			  	        int packages= prod.getPackages();
			  	        System.out.println("packages="+packages);
			  	         System.out.println("name1="+name1);
			  	         
			  	         String quantity = search.getString("quantity");
			  	         Integer quantity1 = Integer.parseInt(quantity);
			  	         bill.setQuantity(quantity1);
			  	         int quantity2 = packages-quantity1;
			  	         int id = prod.getP_id();
			  	       System.out.println("id="+id);
//				  	       if(packages < quantity2)
			  	     Date date1=new Date(new java.util.Date().getTime());
			  	       productService.updateQuantity(id, quantity2);
			  	      boolean value = productService.checkProduct(date1,name1);
			  	      if(value==true) {
			  	    	  productService.updateProdQty(date1,name1,quantity);
			  	    	  
			  	      }else {
			  	    	  ProductReport pr = new ProductReport();
			  	         Date dat=new Date(new java.util.Date().getTime());
			  	         pr.setDate(dat);
			  	         pr.setProduct(prod);
			  	         pr.setPr_active("1");
			  	         pr.setQuantity(quantity1);
			  	        // String p_name = helper.getProductByName(name1);
			  	         pr.setName(name1);
			  	         productService.saveProductReport(pr);
			  	      }
			  	       System.out.println("quantity2="+quantity2);
			  	         System.out.println("quantity1="+quantity1);
			  	         
//				  	         ProductReport pr = new ProductReport();
//				  	         Date dat=new Date(new java.util.Date().getTime());
//				  	         pr.setDate(dat);
//				  	         pr.setProduct(prod);
//				  	         pr.setPr_active("1";
//				  	         pr.setQuantity(quantity1);
//				  	         productService.saveProductReport(pr);
//				  	         

			  	         String rate = search.getString("rate");
			  	         Float rate1 = Float.parseFloat(rate);
			  	         bill.setRate(rate1);
			  	         System.out.println("rate="+rate);
			  	         
			  	        
			  	         String gst = search.getString("gst");
			  	         Integer gst1 = Integer.parseInt(gst);
			  	         bill.setGstPer(gst1);
			  	         System.out.println("gst="+gst);
			  	         
			  	         String gstType = search.getString("gstType");
			  	         Integer gstType1 = Integer.parseInt(gstType);
			  	         bill.setGstType(gstType1);
			  	         System.out.println("gstType="+gstType);
			  	         
			  	         bill.setB_active(1);
			  	         
			  	        Boolean value1 =productService.saveBill(bill);
			        	   }
			        	   catch(Exception ex) {
			        	    break;
			        	   }
			  	         
			  	     
			         }
			         System.out.println("Done.............");
			         
			     
			        
			 

			 response.getWriter().write(json.toString());
			 return;

			     }

//	 
//	 @CrossOrigin(origins="http://localhost:4200")
//	 @RequestMapping(value = "/save_bill", method = RequestMethod.POST)
//	 public void save_bill(
//	 @ModelAttribute("mergedata2") @Valid Bill bill, 
//	 BindingResult result,
//	 ModelMap model,
//	 HttpServletRequest request, 
//	 HttpServletResponse response)
//
//	  throws IOException {
//
//	 response.setContentType("application/json");
//	         response.setCharacterEncoding("UTF-8");
//	         json=new JSONObject();
//	        
//	         String data = "";   
//	         StringBuilder builder = new StringBuilder();
//	         BufferedReader reader = request.getReader();
//	         String line;
//	         while ((line = reader.readLine()) != null) {
//	             builder.append(line);
//	         }
//	         data = builder.toString();
//	         System.out.println(data);
//	         JSONObject jsonObj = new JSONObject(data);
//	         System.out.println(jsonObj);
//	         
//	         String name = jsonObj.getString("name");
//	         Customer cust = helper.getCustomerByName(name);
//	         bill.setCustomer(cust);
//	         System.out.println("name="+name);
//	         
//	         Integer bill_no = (Integer) jsonObj.get("bill_no");
//	        // Integer no = Integer.parseInt(bill_no);
//	         bill.setB_number(bill_no);
//	         System.out.println("bill_no="+bill_no);
//	         
//	         String date = jsonObj.getString("date");
//	         bill.setDate(date);
//	         System.out.println("date="+date);
//	         
//	         String grossamt = (String) jsonObj.get("grossamt");
//	         Float gross1 = Float.parseFloat(grossamt);
//	         bill.setGrossamt(gross1);
//	         System.out.println("grossamt="+grossamt);
//	         
//	         String cgst = (String) jsonObj.get("cgst");
//	         Float cgst1 = Float.parseFloat(cgst);
//	         bill.setCgst(cgst1);
//	         System.out.println("cgst="+cgst);
//	         
//	         String sgst = (String) jsonObj.get("sgst");
//	         Float sgst1 = Float.parseFloat(sgst);
//	         bill.setSgst(sgst1);
//	         System.out.println("sgst="+sgst);
//	         
//	         Integer igst = (Integer) jsonObj.get("igst");
//	         bill.setIgst(igst);
//	         System.out.println("igst="+igst);
//	         
//	         String gstamount = (String) jsonObj.get("gstamount");
//	         Float gstamount1 = Float.parseFloat(gstamount);
//	         bill.setGstamt1(gstamount1);
//	         System.out.println("gstamount1="+gstamount1);
//	         
//	         String netamt = (String) jsonObj.get("netamt");
//	         Float netamt1 = Float.parseFloat(netamt);
//	         bill.setNetamt(netamt1);
//	         System.out.println("netamt1="+netamt1);
//	         
//	         CustReport cr = new CustReport();
//	         cr.setB_number(bill_no);
//	         cr.setDate(date);
//	         cr.setGrossamt(gross1);
//	         cr.setCgst(cgst1);
//	         cr.setSgst(sgst1);
//	         cr.setIgst(igst);
//	         cr.setGstamt1(gstamount1);
//	         cr.setNetamt(netamt1);
//	         cr.setCr_active(1);
//	         cr.setCustomer(cust);
//	         productService.saveCr(cr);
//	         
//	         
//	         String arr1[]= {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
//	        		 		"21","22","23","24","25","26","27","28","29","30"};
//	         for (int i = 0; i < arr1.length; i++) {
//	        	 
//	        	   String arr=arr1[i];
//	        	   try {
//	        	 JSONObject search = (JSONObject) jsonObj.get(arr);
//	  	         System.out.println("search="+search);
//	  	         
//	  	         String ans3 = search.getString("ans3");
//	  	         Float ans31 = Float.parseFloat(ans3);
//	  	         bill.setAmount(ans31);
//	  	         System.out.println("ans31="+ans31);
//	  	         
//	  	         
//	  	         String ans2 = search.getString("ans2");
//	  	         Float ans21 = Float.parseFloat(ans2);
//	  	         bill.setGstAmount(ans21);
//	  	         System.out.println("ans2="+ans21);
//	  	         
//	  	         String total = search.getString("total");
//	  	         Float total1 = Float.parseFloat(total);
//	  	         bill.setTotal(total1);
//	  	         System.out.println("total="+total);
//	  	         
//	  	         String name1 = search.getString("name");
//	  	         Product prod = helper.getProductByName(name1);
//	  	         bill.setProduct(prod);
//	  	        int packages= prod.getPackages();
//	  	        System.out.println("packages="+packages);
//	  	         System.out.println("name1="+name1);
//	  	         
//	  	         String quantity = search.getString("quantity");
//	  	         Integer quantity1 = Integer.parseInt(quantity);
//	  	         bill.setQuantity(quantity1);
//	  	         int quantity2 = packages-quantity1;
//	  	         int id = prod.getP_id();
//	  	       System.out.println("id="+id);
////	  	       if(packages < quantity2)
//	  	       productService.updateQuantity(id, quantity2);
//	  	       System.out.println("quantity2="+quantity2);
//	  	         System.out.println("quantity1="+quantity1);
//	  	         
//	  	         ProductReport pr = new ProductReport();
//	  	         Date dat=new Date(new java.util.Date().getTime());
//	  	         pr.setDate(dat);
//	  	         pr.setProduct(prod);
//	  	         pr.setPr_active("1");
//	  	         pr.setQuantity(quantity1);
//	  	         productService.saveProductReport(pr);
//	  	         
//
//	  	         String rate = search.getString("rate");
//	  	         Float rate1 = Float.parseFloat(rate);
//	  	         bill.setRate(rate1);
//	  	         System.out.println("rate="+rate);
//	  	         
//	  	        
//	  	         String gst = search.getString("gst");
//	  	         Integer gst1 = Integer.parseInt(gst);
//	  	         bill.setGstPer(gst1);
//	  	         System.out.println("gst="+gst);
//	  	         
//	  	         String gstType = search.getString("gstType");
//	  	         Integer gstType1 = Integer.parseInt(gstType);
//	  	         bill.setGstType(gstType1);
//	  	         System.out.println("gstType="+gstType);
//	  	         
//	  	         bill.setB_active(1);
//	  	         
//	  	        Boolean value =productService.saveBill(bill);
//	        	   }
//	        	   catch(Exception ex) {
//	        		   break;
//	        	   }
//	  	         
//	  	     
//	         }
//	         System.out.println("Done.............");
//	         
//	     
//	        
//	 
//
//	 response.getWriter().write(json.toString());
//	 return;
//
//	     }
	 

	 @CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/mng_product_report", method = RequestMethod.POST)
			 public String mng_product_report( 
			 @ModelAttribute("data") @Valid ProductReport pr,
			 Locale locale, 
			 Model model,
			 HttpServletRequest request,
			 HttpServletResponse response) throws IOException {

			  response.setContentType("application/json");
			       response.setCharacterEncoding("UTF-8");
			       json=new JSONObject();
			       String data = "";   
			       StringBuilder builder = new StringBuilder();
			       BufferedReader reader = request.getReader();
			       String line;
			       while ((line = reader.readLine()) != null) {
			           builder.append(line);
			       }
			       data = builder.toString();
			       System.out.println(data);
			       JSONObject jsonObj = new JSONObject(data);
			       System.out.println(jsonObj);
			       
			       String from = jsonObj.getString("from");
			       
			       String to = jsonObj.getString("to");
			   
			       List<ProductReport> bill1=new ArrayList<ProductReport>();

			        bill1 = productService.getProductReport(from,to);
			        
			        System.out.println("bill="+bill1);
			        
			        PrintWriter out = response.getWriter();
			      response.setContentType("application/json");
			      response.setCharacterEncoding("UTF-8");
			      Gson json = new Gson();
			      String Json=null;
			    
			      String Json1=null;
				    
			      	  Json=json.toJson(bill1);
			      	
			      	 System.out.print("jsonnnn===="+Json);
			    
			     	        
			      model.addAttribute("Json", Json);
			 model.addAttribute("url", request.getRequestURI());
			       

			 response.getWriter().write(json.toString());
			 return "bill/custR";

			 }
	 
	 

	 @CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/mng_product_report1", method = RequestMethod.POST)
			 public String mng_product_report1( 
			 @ModelAttribute("data") @Valid ProductReport pr,
			 Locale locale, 
			 Model model,
			 HttpServletRequest request,
			 HttpServletResponse response) throws IOException {

			  response.setContentType("application/json");
			       response.setCharacterEncoding("UTF-8");
			       json=new JSONObject();
			       String data = "";   
			       StringBuilder builder = new StringBuilder();
			       BufferedReader reader = request.getReader();
			       String line;
			       while ((line = reader.readLine()) != null) {
			           builder.append(line);
			       }
			       data = builder.toString();
			       System.out.println(data);
			       JSONObject jsonObj = new JSONObject(data);
			       System.out.println(jsonObj);
			       
			       String from = jsonObj.getString("from");
			       
			       String to = jsonObj.getString("to");
			   
			       List<ProductReport> bill1=new ArrayList<ProductReport>();

			        bill1 = productService.getProductReport1(from,to);
			        
			        System.out.println("bill="+bill1);
			        
			        PrintWriter out = response.getWriter();
			      response.setContentType("application/json");
			      response.setCharacterEncoding("UTF-8");
			      Gson json = new Gson();
			      String Json=null;
			    
			      String Json1=null;
				    
			      	  Json=json.toJson(bill1);
			      	
			      	 System.out.print("jsonnnn===="+Json);
			    
			     	        
			      model.addAttribute("Json", Json);
			 model.addAttribute("url", request.getRequestURI());
			       

			 response.getWriter().write(json.toString());
			 return "bill/mng_product_report1";

			 }


	 
	 @CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/custR", method = RequestMethod.POST)
			 public String custR(
			 @ModelAttribute("data") @Valid CustReport cr, 
			 BindingResult result,
			 ModelMap model,
			 HttpServletRequest request, 
			 HttpServletResponse response)

			  throws IOException {

			 response.setContentType("application/json");
			         response.setCharacterEncoding("UTF-8");
			         json=new JSONObject();
			         
//				         JSONObject jsonObj1 = new JSONObject("value";
//				         System.out.println("result="+jsonObj1);
			         
			        
			         String data = "";   
			         StringBuilder builder = new StringBuilder();
			         BufferedReader reader = request.getReader();
			         String line;
			         while ((line = reader.readLine()) != null) {
			             builder.append(line);
			         }
			         data = builder.toString();
			         System.out.println(data);
			         JSONObject jsonObj = new JSONObject(data);
			         System.out.println(jsonObj);
			         
			         String name = jsonObj.getString("name");
			         Customer cust = helper.getCustomerByName(name);
			         int id = cust.getC_id();

			         String from = jsonObj.getString("from");
			         
			         String to = jsonObj.getString("to");
			     
			         List<CustReport> bill1=new ArrayList<CustReport>();

			          bill1 = productService.custReport(id,from,to);
			          
			          System.out.println("bill="+bill1);
			          
			          PrintWriter out = response.getWriter();
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        Gson json = new Gson();
			        String Json=null;
			      
			        	  Json=json.toJson(bill1);
			        	 out.print(Json);
			       	        
			        model.addAttribute("Json", Json);
			model.addAttribute("url", request.getRequestURI());
			         

			 response.getWriter().write(json.toString());
			 return "bill/custR";

			     }

	 
	 @CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/allcustR", method = RequestMethod.POST)
	 public String allcustR(
	 @ModelAttribute("data") @Valid CustReport cr, 
	 BindingResult result,
	 ModelMap model,
	 HttpServletRequest request, 
	 HttpServletResponse response)

	  throws IOException {

	 response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         json=new JSONObject();
	         

	         String data = "";   
	         StringBuilder builder = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             builder.append(line);
	         }
	         data = builder.toString();
	         System.out.println(data);
	         JSONObject jsonObj = new JSONObject(data);
	         System.out.println(jsonObj);
	         
//	         String name = jsonObj.getString("name");
//	         Customer cust = helper.getCustomerByName(name);
//	         int id = cust.getC_id();

	         String from = jsonObj.getString("from");
	         
	         String to = jsonObj.getString("to");
	     
	         List<CustReport> bill1=new ArrayList<CustReport>();

	          bill1 = productService.allcustReport(from,to);
	          
	          System.out.println("bill="+bill1);
	          
	          PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	      
	        	  Json=json.toJson(bill1);
	        
	        	 out.print(Json);
	       	        
	        model.addAttribute("Json", Json);
	model.addAttribute("url", request.getRequestURI());
	         

	 response.getWriter().write(json.toString());
	 return "bill/custR";

	     }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
		@RequestMapping(value = "/quantity", method = RequestMethod.GET)
		public void quantity(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
				throws IOException {

		  List<Product> bill1=new ArrayList<Product>();
		  bill1=productService.getQty();

		
		 
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Gson json = new Gson();
			String Json = null;
		
			Json = json.toJson(bill1);
			out.print(Json);
			

		}


	 
	
}
