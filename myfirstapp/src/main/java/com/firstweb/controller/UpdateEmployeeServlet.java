package com.firstweb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.EmployeeModel;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		System.out.println("DOGET ENTERED");
		AdminDAO dao = new AdminDAO();
		EmployeeModel employee = dao.getEmployeeById(empno); // Fetch employee by ID
		System.out.println("DOGETPROCESSING");
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		System.out.println("DO POST ENTERED");
		int empno = Integer.parseInt(request.getParameter("empno"));
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String empJob = request.getParameter("empJob");
		String empStatus = request.getParameter("empStatus");
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));

		// Create an EmployeeModel object with updated values
		EmployeeModel employee = new EmployeeModel(empno, empName, gender, empJob, empStatus, deptNo);

		// Update employee in the database
		AdminDAO dao = new AdminDAO();
		String status = dao.updateEmployee(employee);

		if (status.equals("true")) {
			response.sendRedirect("welcome.jsp"); // Redirect to welcome page on success
		} else {
			request.setAttribute("errorMessage", "Update failed. Please try again.");
			request.setAttribute("employee", employee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
			dispatcher.forward(request, response);

		}
	}

}
