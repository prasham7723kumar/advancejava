package com.firstweb.controller;

import java.io.IOException;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.EmployeeModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employeeadd")

public class EmployeeAddControlle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet Entery");
		String empname = request.getParameter("empname");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String empstatus = request.getParameter("empstatus");
		String dno = request.getParameter("deptno");
		int deptno = Integer.parseInt(dno);
		System.out.println(empname + " " + gender + " " + job + " " + empstatus + " " + deptno);
		EmployeeModel em = new EmployeeModel();
		em.setEmpName(empname);
		em.setGender(gender);
		em.setEmpJob(job);
		em.setEmpStatus(empstatus);
		em.setDeptNo(deptno);
		System.out.println(em);
		AdminDAO dao1 = new AdminDAO();
		String status1 = dao1.insertEmployee(em);
		if (status1.equals("true")) {
			System.out.println("Data entered");
			RequestDispatcher disp = request.getRequestDispatcher("welcome.jsp");
			disp.include(request, response);

		} else {
			System.out.println("Not entred");
			RequestDispatcher disp = request.getRequestDispatcher("addemployee.jsp");
			disp.include(request, response);
		}

	}

}
