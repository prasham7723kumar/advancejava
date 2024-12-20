package com.firstweb.controller;

import java.io.IOException;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.AddDepartment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Adddepartment")
public class AddDepcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dname = request.getParameter("dname");
		String dloc = request.getParameter("dloc");

		AddDepartment adde = new AddDepartment();
		adde.setDeptName(dname);
		adde.setLocation(dloc);

		AdminDAO adao = new AdminDAO();
		String status = adao.addDepartment(adde);
		if (status.equals("true")) {
			RequestDispatcher disp = request.getRequestDispatcher("welcome.jsp");
			System.out.println("Yes data entered");
			disp.include(request, response);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("adddept.jsp"); 
			System.out.println("Data not visible");
			disp.include(request, response);

		}

	}

}
