package com.firstweb.controller;

import java.io.IOException;
import java.util.List;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.AddDepartment;
import com.firstweb.model.EmployeeModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/depdisplay")

public class DispDepController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispDepController() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adao = new AdminDAO();
		List<AddDepartment> department = adao.getDepartmentInfo();
		request.setAttribute("department", department); 
		System.out.println("hi");

		RequestDispatcher rdisp = request.getRequestDispatcher("/depdis.jsp");
		rdisp.forward(request, response);

	}

}
