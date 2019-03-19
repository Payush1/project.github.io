package com.grizzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.grizzly.entity.Product;
import com.grizzly.entity.Vendor;
import com.grizzly.service.ProductService;

@Controller
public class VendorController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired@Qualifier("VendorValidator")
	private Validator vendorvalidator;
	
	@RequestMapping(value="vendorloginpage.htm",method=RequestMethod.GET)
	public ModelAndView showVendorLogin(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("vendorlogin");
		return mv;
	}
	
	@RequestMapping(value="loginvendor.htm",method=RequestMethod.POST)
	public ModelAndView loginVendor(@ModelAttribute("vendor")Vendor vendor,Errors errors){
		ValidationUtils.invokeValidator(vendorvalidator, vendor, errors);
		ModelAndView mv=new ModelAndView();
		if(errors.hasErrors()){
			mv.setViewName("vendorlogin");
		}else{
			List<Product> productList=productService.getAllProducts();
			mv.addObject("vendor",vendor);
			mv.addObject("productList",productList);
			mv.setViewName("addvendorproducts");
			
		}
		return mv;
	}
	@ModelAttribute("vendor")
	public Vendor initiateAdmin(){
		ModelAndView mv=new ModelAndView();
		Vendor vendor=new Vendor();
		return vendor;
	}

}
