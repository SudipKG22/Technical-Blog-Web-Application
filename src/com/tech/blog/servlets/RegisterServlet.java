package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;


@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("Inside processRequest method of RegisterServlet class....");
		
		PrintWriter out = response.getWriter();
		
		String termsAndConditionsCheck = request.getParameter("check");
		if(termsAndConditionsCheck == null) {
			out.println("Please agree to the terms and conditions!");
		} else {
			String userName = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String gender = request.getParameter("gender");
			String about = request.getParameter("about");
			
			// Create new User object and set all data to that object
			User newUser = new User(userName, email, password, gender, about);
			
			// Create UserDao object
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			boolean registrationStatus = dao.addUser(newUser);
			
			if(registrationStatus) {
				out.println("DONE");
			} else {
				out.println("Registration failed! Try Again.");
			}
			
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet : doGet() called...");
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet : doPost() called...");
		processRequest(request, response);
	}

}
