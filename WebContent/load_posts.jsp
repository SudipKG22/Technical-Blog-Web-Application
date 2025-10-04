<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.dao.LikeDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Your custom blog card styling -->
    <link rel="stylesheet" href="css/load_posts.css">
</head>
<body>

<div class="row">
    <%
        User user = (User) session.getAttribute("currentuser");

        Thread.sleep(500);
        PostDao dao = new PostDao(ConnectionProvider.getConnection());
        List<Post> posts = null;

        int catid = Integer.parseInt(request.getParameter("cid"));

        if (catid == 0) {
            posts = dao.getAllPosts();
        } else {
            posts = dao.getPostsByCategory(catid);
        }

        if (posts.size() == 0) {
            out.println("<h3 class='display-3 text-center'>No Posts in this category..</h3>");
            return;
        }

        for (Post p : posts) {
    %>

    <div class="col-md-6 mt-2">
        <div class="card">
        	<%
        		String postImage = p.getPostImage();
        		if (postImage == null || postImage.trim().equals("")) {
            		postImage = "DefaultImagePost.png";  // fallback image
        		}
    		%>
            <img class="card-img-top" src="image_blogs/<%= postImage %>" alt="Card image">

            <div class="card-body">
                <b><%= p.getPostTitle() %></b>
                <p>
                    <%= p.getPostContent().length() > 200
                            ? p.getPostContent().substring(0, 200) + "..."
                            : p.getPostContent()
                    %>
                </p>
            </div>

            <div class="card-footer primary-background bg-dark text-center">
                <%
                    LikeDao ld = new LikeDao(ConnectionProvider.getConnection());
                %>
                <a href="#!" onclick="doLike(<%= p.getPostId() %>, <%= user.getUserId() %>)" class="btn btn-outline-light btn-sm">
                    <i class="fa fa-thumbs-o-up"></i> <%= ld.countLikeOnPost(p.getPostId()) %>
                </a>
                <a href="show_blog_page.jsp?post_id=<%= p.getPostId() %>" class="btn btn-outline-light btn-sm">Read More...</a>
                <a href="#!" class="btn btn-outline-light btn-sm">
                    <i class="fa fa-commenting-o"></i> <span>20</span>
                </a>
            </div>
        </div>
    </div>

    <%
        }
    %>
</div>

</body>
</html>
