package com.grizzly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grizzly.dao.AdminDAO;
import com.grizzly.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public boolean validateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.loginAdmin(admin);
	}

	
	
	

}
