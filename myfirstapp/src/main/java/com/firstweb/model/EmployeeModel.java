package com.firstweb.model;

//private final int empno
//toString
//hashcode
//equals
//
public class EmployeeModel {
	private int empno;
	private String empName;
	private String empJob;
	private String gender;
	private String empStatus;
	private int deptNo;

	public EmployeeModel() {
	}

	public EmployeeModel(int empno, String empName, String gender, String empJob, String empStatus, int deptNo) {
		this.empno = empno;
		this.empName = empName;
		this.gender = gender;
		this.empStatus = empStatus;
		this.deptNo = deptNo;
		this.empJob = empJob;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	@Override
	public String toString() {
		return "EmployeeModel [empno=" + empno + ", empName=" + empName + ", empJob=" + empJob + ", gender=" + gender
				+ ", empStatus=" + empStatus + ", deptNo=" + deptNo + "]";
	}

}
