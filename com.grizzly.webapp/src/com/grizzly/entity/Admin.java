package com.grizzly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@Column(name="adminid")
	private String adminId;
	@Column(name="adminname")
	private String adminName;
	@Column(name="adminpassword")
	private String adminPassword;
	@Column(name="office")
	private String adminOffice;
	@Column(name="desig")
	private String adminDesignation;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminOffice() {
		return adminOffice;
	}
	public void setAdminOffice(String adminOffice) {
		this.adminOffice = adminOffice;
	}
	public String getAdminDesignation() {
		return adminDesignation;
	}
	public void setAdminDesignation(String adminDesignation) {
		this.adminDesignation = adminDesignation;
	}

}
