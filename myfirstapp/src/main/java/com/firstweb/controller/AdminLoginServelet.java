package com.firstweb.controller;

import java.io.IOException;
import java.util.List;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.EmployeeModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")

public class AdminLoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServelet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adao = new AdminDAO();
		List<EmployeeModel> employee = adao.getAdminInfo();
		request.setAttribute("employee", employee); 
		System.out.println("hi");

		RequestDispatcher rdisp = request.getRequestDispatcher("/home.jsp");
		rdisp.forward(request, response);

	}

}
