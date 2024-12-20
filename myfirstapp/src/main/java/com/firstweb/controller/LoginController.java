package com.firstweb.controller;

import java.io.IOException;

import com.firstweb.dao.AdminDAO;
import com.firstweb.model.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dopost code here");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginModel lm = new LoginModel();
		lm.setEmail(email);
		lm.setPassword(password);

		AdminDAO adao = new AdminDAO();
		boolean status = adao.checkAdminInfo(lm);

		if (status) {
			System.out.println("value checked");
			RequestDispatcher rdisp = request.getRequestDispatcher("welcome.jsp");
			rdisp.forward(request, response);
		} else {
			System.out.println("Not Checked");
			request.setAttribute("errorMessage", "Invalid credentials! Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response); // Forward to index.jsp with error message
		}
	}

}
