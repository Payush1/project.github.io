package com.grizzly.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grizzly.entity.Vendor;
import com.grizzly.service.VendorService;
@Component("VendorValidator")
public class VendorValidator implements Validator  {
	
	@Autowired
	private VendorService vendorService;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(Vendor.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		Vendor vendor=(Vendor)arg0;
		boolean vendorAuth=vendorService.loginVendor(vendor);
		System.out.println(vendorAuth);
		if(!vendorAuth){
			arg1.rejectValue("vendorName", "com.cognizant.entity.Vendor.vendorName.invalid");
		}
		
	}

}
