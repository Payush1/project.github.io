package com.grizzly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grizzly.entity.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean validateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("select o from Vendor o where o.vendorId=:vendorId and o.vendorPassword=:vendorPassword");
		query.setString("vendorId",vendor.getVendorId());
		query.setString("vendorPassword",vendor.getVendorPassword());
		boolean vendorExists=true;
		List<Vendor> vendorList=query.list();
		if(vendorList.isEmpty())
				vendorExists=false;
		session.close();	
		return vendorExists;
	
	}

}
