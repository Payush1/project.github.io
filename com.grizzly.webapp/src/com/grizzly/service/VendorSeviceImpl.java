package com.grizzly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grizzly.dao.VendorDAO;
import com.grizzly.entity.Vendor;

@Service
public class VendorSeviceImpl implements VendorService {
	@Autowired
	private VendorDAO vendorDAO;
	@Override
	public boolean loginVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorDAO.validateVendor(vendor);
	}

}
