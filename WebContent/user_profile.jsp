<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tech.blog.entities.User" %>
<%@page import="com.tech.blog.entities.Message" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.tech.blog.entities.Category" %>
<%@page import="com.tech.blog.dao.PostDao" %>
<%@page import="com.tech.blog.helper.ConnectionProvider" %>

 
<%
	User user = (User) session.getAttribute("currentuser");
	if(user == null) {
		response.sendRedirect("login_page.jsp");
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Profile</title>
		
		<!-- CSS -->
		<link href="css/index-style.css" rel="stylesheet" type="text/css"/>
		<link href="css/user_profile.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			.banner-background {
   				clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
			}
			body {
    			background: url('img/post-bg-3.jpg') no-repeat center center fixed;
    			background-size: cover;
    			font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    			color: #333;
			}
		</style>
	</head>
		
		
	<body>
		<!-- Navigation bar-->
        <%@include  file="register_navbar.jsp" %>
        
        <!--  -->
        <%
			Message msg = (Message) session.getAttribute("message");
			if(msg != null) {
		%>
		<div class="alert <%= msg.getCssClass() %>" role="alert">
              <%= msg.getContent() %>
        </div>
		<%
				session.removeAttribute("message");
			}
		%>
		
		
		<!--Start of Main body of the page-->

        <main>
            <div class="container">
                <div class="row mt-4">
                    <!-- First column -->
                    <div class="col-md-4">
                        <!-- Categories -->
                        <div class="list-group">
                            <a href="#" onclick="getPosts(0, this)"  class=" c-link list-group-item list-group-item-action active">
                                All Posts
                            </a>
                            <!-- Categories -->

                            <%  PostDao dao = new PostDao(ConnectionProvider.getConnection());
                                ArrayList<Category> catgList = dao.getAllCategories();
                                for (Category cat : catgList) {

                            %>
                            <a href="#" onclick="getPosts(<%= cat.getCatId() %>, this)" class=" c-link list-group-item list-group-item-action"><%= cat.getCatName() %></a>


                            <%                                        
                            	}
                            %>
                        </div>

                    </div>

                    <!-- Second column -->
                    <div class="col-md-8" >
                        <!-- Posts -->
                        <div class="container text-center" id="loader">
                            <i class="fa fa-refresh fa-4x fa-spin"></i>
                            <h3 class="mt-2">Loading...</h3>
                        </div>

                        <div class="container-fluid" id="post-container">

                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!-- End of main body of the page-->
		
        
        <!-- Profile Modal-->
        <div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header primary-background text-white text-center">
                        <h5 class="modal-title" id="exampleModalLabel"> TechBlog </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container text-center">
                        	<%
        						String userImage = user.getProfile();
        						if (userImage == null || userImage.trim().equals("")) {
        							userImage = "default.jpg";  // fallback image
        						}
    						%>
                            <img src="image_profiles/<%= userImage %>" class="img-fluid" style="border-radius:50%;max-width: 150px;;" >
                            <br>
                            <h5 class="modal-title mt-3" id="exampleModalLabel"> <%= user.getUserName()%> </h5>
                            
                            <!-- Details -->

                            <div id="profile-details">
                                <table class="table">

                                    <tbody>
                                        <tr>
                                            <th scope="row">User ID :</th>
                                            <td> <%= user.getUserId() %> </td>

                                        </tr>
                                        <tr>
                                            <th scope="row"> Email : </th>
                                            <td> <%= user.getEmail() %> </td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Gender :</th>
                                            <td> <%= user.getGender().toUpperCase() %> </td>

                                        </tr>
                                        <tr>
                                            <th scope="row">About :</th>
                                            <td> <%= user.getAbout() %> </td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Registered On :</th>
                                            <td> <%= user.getRegDate().toString()%> </td>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
                            <!-- Profile Edit -->
                            <div id="profile-edit" style="display: none;">
                                <h3 class="mt-2">Please Edit Carefully</h3>
                                <form action="EditProfileServlet" method="post" enctype="multipart/form-data">
                                    <table class="table">
                                        <tr>
                                            <td>User ID :</td>
                                            <td><%= user.getUserId()%></td>
                                        </tr>
                                        <tr>
                                            <td>Email :</td>
                                            <td> <input type="email" class="form-control" name="user_email" value="<%= user.getEmail()%>" > </td>
                                        </tr>
                                        <tr>
                                            <td>Name :</td>
                                            <td> <input type="text" class="form-control" name="user_name" value="<%= user.getUserName()%>" > </td>
                                        </tr>
                                        <tr>
                                            <td>Password :</td>
                                            <td> <input type="password" class="form-control" name="user_password" value="<%= user.getPassword()%>" > </td>
                                        </tr>
                                        <tr>
                                            <td>Gender :</td>
                                            <td> <%= user.getGender().toUpperCase()%> </td>
                                        </tr>
                                        <tr>
                                            <td>About  :</td>
                                            <td>
                                                <textarea rows="3" class="form-control" name="user_about" ><%= user.getAbout()%>
                                                </textarea>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Edit Profile Picture:</td>
                                            <td>
                                                <input type="file" name="image" class="form-control" >
                                            </td>
                                        </tr>

                                    </table>

                                    <div class="container">
                                        <button type="submit" class="btn btn-outline-primary">Save</button>
                                    </div>

                                </form>    

                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button  id="edit-profile-button" type="button" class="btn btn-primary">EDIT</button>
                    </div>
                </div>
            </div>
        </div>
        <!--End of profile modal-->
        
        
        <!--Start of Post modal-->
        <div class="modal fade" id="add-post-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Provide the post details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <form id="add-post-form" action="AddPostServlet" method="post">

                            <div class="form-group">
                                <select class="form-control" name="cid">
                                    <option selected disabled>--- Select Category ---</option>
									<%
                                        PostDao postd = new PostDao(ConnectionProvider.getConnection());
                                        ArrayList<Category> catList = postd.getAllCategories();
                                        for (Category c : catList) {
                                    %>
                                    <option value="<%= c.getCatId()%>"><%= c.getCatName()%></option>

                                    <%
                                        }
                                    %>
                                    
                                </select>
                            </div>

                            <div class="form-group">
                                <input name="pTitle" type="text" placeholder="Enter post Title" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <textarea name="pContent" class="form-control" style="height: 200px;" placeholder="Enter your content"></textarea>
                            </div>
                            <div class="form-group">
                                <textarea name="pCode" class="form-control" style="height: 200px;" placeholder="Enter your program (if any)"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Select Your Image</label>
                                <br>
                                <input type="file" name="pic"  >
                            </div>

                            <div class="container text-center">
                                <button type="submit" class="btn btn-outline-primary">Post </button>
                            </div>

                        </form>


                    </div>

                </div>
            </div>
        </div>
        <!--End of Post modal-->
        
		
			
			
		<!-- JAVASCRIPTS -->	
		<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
		<script src="js/user-profile.js"></script>	
	</body>
</html>