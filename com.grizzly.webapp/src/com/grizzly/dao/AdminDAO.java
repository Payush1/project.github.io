package com.grizzly.dao;

import org.springframework.stereotype.Repository;

import com.grizzly.entity.Admin;


public interface AdminDAO {
	
	boolean loginAdmin(Admin admin);

}
