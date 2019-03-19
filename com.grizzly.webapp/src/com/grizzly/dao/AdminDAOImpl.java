package com.grizzly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grizzly.entity.Admin;
import com.grizzly.entity.Product;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("select o from Admin o where o.adminName=:adminName and o.adminPassword=:adminPassword");
		System.out.println(admin.getAdminName());
		System.out.println(admin.getAdminPassword());
		query.setString("adminName", admin.getAdminName());
		query.setString("adminPassword",admin.getAdminPassword() );
		boolean adminExists=true;
		List<Admin> adminList=query.list();
		if(adminList.isEmpty())
				adminExists=false;
		session.close();	
		return adminExists;
	}
	

}
