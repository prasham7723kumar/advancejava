package com.firstweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.firstweb.model.AddDepartment;
import com.firstweb.model.EmployeeModel;
import com.firstweb.model.LoginModel;

public class AdminDAO {
	Connection con;

	public boolean checkAdminInfo(LoginModel lm) {
		boolean status = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from login where email=? and password =?");
			ps.setString(1, lm.getEmail());
			ps.setString(2, lm.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public List<EmployeeModel> getAdminInfo() {

		List<EmployeeModel> li = new ArrayList<>();
		// EmployeeModel em = new EmployeeModel();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int a = rs.getInt(1);
				String s1 = rs.getString(2);
				String s2 = rs.getString(3);
				String s3 = rs.getString(4);
				String s4 = rs.getString(5);
				int b = rs.getInt(6);

				li.add(new EmployeeModel(a, s1, s2, s3, s4, b));

			}
			System.out.println("while closed");

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(li);
		return li;

	}

	public String addDepartment(AddDepartment add) {
		String status = "failure";
		System.out.println("DAO Entered");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into department values(?,?,?)");
			ps.setInt(1, add.getDeptNo());
			ps.setString(2, add.getDeptName());
			ps.setString(3, add.getLocation());
			int n = ps.executeUpdate();
			System.out.println(n);
			if (n > 0) {
				System.out.println("Inserted Sucessfully");
				status = "true";
			} else {
				System.out.println("Something went wrong");
				status = "failure";
			}

		} catch (Exception e) {

		}
		return status;
	}

	public String insertEmployee(EmployeeModel em) {
		String status = "false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");

			PreparedStatement ps = con
					.prepareStatement("insert into employee(empname,gender,job,empstatus,deptno) values(?,?,?,?,?) ");

			ps.setString(1, em.getEmpName());
			ps.setString(2, em.getGender());
			ps.setString(3, em.getEmpJob());
			ps.setString(4, em.getEmpStatus());
			ps.setInt(5, em.getDeptNo());
			int n = ps.executeUpdate();
			System.out.println(n);
			if (n > 0) {
				System.out.println("Employee added");
				status = "true";
			} else {
				System.out.println("Employee not added..sorry");
				status = "false";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return status;
	}

	public List<AddDepartment> getDepartmentInfo() {
		List<AddDepartment> dep = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from department");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int a = rs.getInt(1);
				String a1 = rs.getString(2);
				String b1 = rs.getString(3);
				dep.add(new AddDepartment(a, a1, b1));
			}
			System.out.println("closed 2");
		} catch (Exception e) {
			System.out.println(e);
		}

		return dep;

	}

	public boolean deleteEmp(EmployeeModel em) {
		boolean status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from employee where empno = ? ");
			ps.setInt(1, em.getEmpno());
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Deleted");
				status = true;
			} else {
				System.out.println("Sorry Eroor");
				status = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public String updateEmployee(EmployeeModel em) {
		String status = "false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");

			PreparedStatement ps = con.prepareStatement(
					"UPDATE employee SET empname = ?, gender = ?, job = ?, empstatus = ?, deptno = ? WHERE empno = ?");

			ps.setString(1, em.getEmpName());
			ps.setString(2, em.getGender());
			ps.setString(3, em.getEmpJob());
			ps.setString(4, em.getEmpStatus());
			ps.setInt(5, em.getDeptNo());
			ps.setInt(6, em.getEmpno());

			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Employee updated successfully");
				status = "true";
			} else {
				System.out.println("Failed to update employee");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String updateDepartment(AddDepartment am) {
		String status = "false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/office", "root", "root");

			PreparedStatement ps = con
					.prepareStatement("UPDATE department set DeptName = ?, Location = ? Where DeptNo = ? ");
			ps.setString(1, am.getDeptName());
			ps.setString(2, am.getLocation());
			ps.setInt(3, am.getDeptNo());
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Update Inprogress");
				status = "true";
			} else {
				System.out.println("Not updated");
				status = "false";
			}
		} catch (Exception e) {

		}
		return status;
	}

	public AddDepartment getDepartmentById(int deptNo) {
		AddDepartment department = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM department WHERE DeptNo = ?");
			ps.setInt(1, deptNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				department = new AddDepartment();
				department.setDeptNo(rs.getInt("DeptNo"));
				department.setDeptName(rs.getString("DeptName"));
				department.setLocation(rs.getString("Location"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}

	public EmployeeModel getEmployeeById(int empno) {
		EmployeeModel em = null;
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE empno = ?");
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				em = new EmployeeModel();
				em.setEmpno(rs.getInt("empno"));
				em.setEmpName(rs.getString("empname"));
				em.setGender(rs.getString("gender"));
				em.setEmpJob(rs.getString("job"));
				em.setEmpStatus(rs.getString("empstatus"));
				em.setDeptNo(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}

}
