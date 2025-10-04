package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.LikeDao;
import com.tech.blog.helper.ConnectionProvider;


@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LikeServlet() {
        
    }

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String operation = request.getParameter("operation");
    	int userId = Integer.parseInt(request.getParameter("userid"));
    	int postId = Integer.parseInt(request.getParameter("postid"));
    	
    	//System.out.println("Data From Like : " + userId + ", " + postId + ", " + operation);
    	
    	LikeDao dao = new LikeDao(ConnectionProvider.getConnection());
    	if(operation.equals("like")) {
    	    boolean alreadyLiked = dao.isPostLikedByUser(postId, userId);
    	    
    	    boolean result;
    	    if (alreadyLiked) {
    	        result = dao.deleteLike(postId, userId); // perform "dislike"
    	        out.println("disliked");
    	    } else {
    	        result = dao.insertLike(postId, userId); // perform "like"
    	        out.println("liked");
    	    }
    	}

    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
