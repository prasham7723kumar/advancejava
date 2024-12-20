package com.firstweb.model;

public class AddDepartment {  
	private int deptNo; 
	private String deptName;
	private String location;
	public AddDepartment() { 
		
	} 
	public AddDepartment(int deptNo,String deptName,String location) { 
		this.deptNo= deptNo;
		this.deptName= deptName;
		this.location= location;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	} 
	



}
