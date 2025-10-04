package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.UpdateImageFile;

@MultipartConfig
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// Fetch User details to edit
		String userEmail = request.getParameter("user_email");
		String userPasword = request.getParameter("user_password");
		String userName = request.getParameter("user_name");
		String userAbout = request.getParameter("user_about");
		String imageName;
		Part part = request.getPart("image");
			
		
		// Get the User from the session
		HttpSession session = request.getSession();
		
		User currentUser = (User) session.getAttribute("currentuser");
		currentUser.setEmail(userEmail);
		currentUser.setUserName(userName);
		currentUser.setPassword(userPasword);
		currentUser.setAbout(userAbout);
		
		String oldImageName = currentUser.getProfile(); // save the old filename
		if (part != null && part.getSize() > 0) {
		    imageName = part.getSubmittedFileName();
		} else {
		    imageName = oldImageName; // no new upload, keep old filename
		}
		currentUser.setProfile(imageName);
		
		// Database Update
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		boolean updatedStatus = dao.updateUser(currentUser);
		if (updatedStatus) {
		    System.out.println("User updated to DB");

		    if (part != null && part.getSize() > 0) {
		        // Only delete old image if a new one was uploaded

		        String folderPath = "C:\\Users\\DELL\\eclipse-workspace\\TechnicalBlogs\\WebContent\\image_profiles";
		        String oldImagePath = folderPath + File.separator + oldImageName;
		        String newImagePath = folderPath + File.separator + currentUser.getProfile();

		        // Delete old image
		        if (!oldImageName.equals("default.jpg")) {
		            UpdateImageFile.deleteFile(oldImagePath);
		        }

		        // Save new image
		        if (UpdateImageFile.saveFile(part.getInputStream(), newImagePath)) {
		            Message message = new Message("Profile picture is updated successfully.", "success", "alert-success");
		            session.setAttribute("message", message);
		        } else {
		            Message message = new Message("Something went wrong while updating profile picture.", "error", "alert-danger");
		            session.setAttribute("message", message);
		        }
		    } else {
		        // No image uploaded, no deletion needed
		        Message message = new Message("Profile updated without changing profile picture.", "success", "alert-success");
		        session.setAttribute("message", message);
		    }
		} else {
			Message message = new Message("Something went wrong while updating user profile.", "error", "alert-danger");
			session.setAttribute("message", message);
		}

		response.sendRedirect("user_profile.jsp");
		
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
