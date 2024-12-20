package com.firstweb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.EmployeeModel;

@WebServlet("/DeleteEmployee")

public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		EmployeeModel em = new EmployeeModel();
		em.setEmpno(id);

		AdminDAO adao = new AdminDAO();
		boolean status = adao.deleteEmp(em);

		if (status) {
			request.setAttribute("message", "Employee deleted Sucessfully");
			request.setAttribute("messageType", "success");
		} else {
			request.setAttribute("message", "Failed to delete Employee.");
			request.setAttribute("messageType", "error");

		}
		List<EmployeeModel> employee = adao.getAdminInfo();
		request.setAttribute("employee", employee); 
		RequestDispatcher rdisp = request.getRequestDispatcher("welcome.jsp");
		rdisp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
