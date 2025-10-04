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

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.UpdateImageFile;

@MultipartConfig
@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Handles both GET and POST requests internally
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside processRequest method of AddPostServlet class....");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// Retrieve the current session and logged-in user
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentuser");


		// Retrieve form data
		int catId = Integer.parseInt(request.getParameter("cid"));
		String postTitle = request.getParameter("pTitle");
		String postContent = request.getParameter("pContent");
		String postCode = request.getParameter("pCode");

		// Retrieve uploaded image file
		Part part = request.getPart("pic");
		String postImage = part.getSubmittedFileName();

		// Get user ID
		int userId = user.getUserId();

		// Create a Post object
		Post newPost = new Post(postTitle, postContent, postCode, postImage, null, catId, userId);

		// Save post using DAO
		PostDao dao = new PostDao(ConnectionProvider.getConnection());
		boolean isPostAddedSuccessfully = dao.addPost(newPost);

		if (isPostAddedSuccessfully) {
			System.out.println("A new post is added to DB");

			// Save uploaded image file if it exists
			if (part != null && part.getSize() > 0) {
				String folderPath = "C:\\Users\\DELL\\eclipse-workspace\\TechnicalBlogs\\WebContent\\image_blogs";
				String imagePath = folderPath + File.separator + postImage;

				boolean isSaved = UpdateImageFile.saveFile(part.getInputStream(), imagePath);
				if (!isSaved) {
					System.out.println("Image file not saved properly.");
				}
			}

			out.println("DONE");

		} else {
			out.println("ERROR");
		}
	}

	// GET method handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Not implemented
	}

	// POST method handler
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
