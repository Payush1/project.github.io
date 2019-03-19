package com.grizzly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.grizzly.entity.Admin;
import com.grizzly.entity.Product;
import com.grizzly.service.AdminService;
import com.grizzly.service.ProductService;

@Controller
@SessionAttributes("thought")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired@Qualifier("ProductValidator")
	private Validator productvalidator;
	

	@Autowired@Qualifier("AdminValidator")
	private Validator adminvalidator;
	


	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public ModelAndView showLoginPage(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="loginadmin.htm",method=RequestMethod.POST)
	public ModelAndView loginAdmin(@ModelAttribute("admin")Admin admin,Errors errors){
		ValidationUtils.invokeValidator(adminvalidator, admin, errors);
		ModelAndView mv=new ModelAndView();
		if(errors.hasErrors()){
			mv.setViewName("login");
		}else{
			List<Product> productList=productService.getAllProducts();
			
			mv.addObject("productList",productList);
			mv.setViewName("viewproducts");
			
		}
		return mv;
	}
	@ModelAttribute("admin")
	public Admin initiateAdmin(){
		ModelAndView mv=new ModelAndView();
		Admin admin=new Admin();
		mv.addObject("thought",admin);
		return admin;
	}
	
	
	@RequestMapping(value="productform.htm",method=RequestMethod.GET)
	public String loadProductForm(){
		return "addproduct";
	}
	@RequestMapping(value="addproduct.htm",method=RequestMethod.POST)
	public ModelAndView persistProduct(@ModelAttribute("product")Product product,Errors errors){
		
		ModelAndView mv=new ModelAndView();

		ValidationUtils.invokeValidator(productvalidator, product, errors);
		if(errors.hasErrors()){
			mv.setViewName("addproduct");
		}else{
		boolean productPersist=productService.persistProduct(product);
		
		if(productPersist){
			mv.addObject("status","Product successfully registered");
		}else{
			mv.addObject("status","Product registration failed");
		}

		mv.setViewName("addproduct");
		}
		return mv;
	}
		
	@RequestMapping(value="deleteproduct.htm",method=RequestMethod.POST)
	public ModelAndView deleteProduct(@RequestParam("productId") int productId){
		boolean productdeleted=productService.deleteProductInfo(productId);
		ModelAndView mv=new ModelAndView();
		if(productdeleted){
			List<Product> productList=productService.getAllProducts();
			
			mv.addObject("productList",productList);
			mv.setViewName("viewproducts");
		}
		return mv;
	}
	@RequestMapping(value="viewproductinfo.htm",method=RequestMethod.GET)
	public ModelAndView fetchProductDescription(@RequestParam("productId") int productId){
		Product product=productService.getProductDescription(productId);
		ModelAndView mv=new ModelAndView();
		mv.addObject("productinfo",product);
		mv.setViewName("showproduct");
		return mv;
	}
	
	@ModelAttribute("product")
	public Product createCommandObject(){
		Product product=new Product();
		product.setProductId(0);
		product.setProductName("Please type product name");
		product.setProductDescription("Please describe product");
		product.setProductPrice(0.0);
		return product;
	}
	@ModelAttribute("categoryList")
	public List<String> createProductCategory(){
		return productService.getProductCategoryNames();
	}
	@RequestMapping(value="logout.htm",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		 request.getSession().invalidate();
		mv.setViewName("login");
		return mv;
	}
}
