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

@WebServlet("/UpdateDepartmentServlet")
public class UpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));

		AdminDAO dao = new AdminDAO();
		AddDepartment department = dao.getDepartmentById(deptNo); // Implement this method in DAO.

		request.setAttribute("department", department);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editDepartment.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        int deptNo = Integer.parseInt(request.getParameter("deptNo"));
        String deptName = request.getParameter("deptName");
        String location = request.getParameter("location");

        AddDepartment department = new AddDepartment(deptNo, deptName, location);

        AdminDAO dao = new AdminDAO();
        String status = dao.updateDepartment(department); // Store the DAO result in a String.

        if (status.equals("true")) { // Check if the update was successful
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("errorMessage", "Update failed. Please try again.");
            request.setAttribute("department", department);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editDepartment.jsp");
            dispatcher.forward(request, response);
	}

} 
}
