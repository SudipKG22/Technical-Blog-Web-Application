<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, com.tech.blog.helper.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Tech Blogs</title>

    <!-- CSS -->
    <link href="css/index-style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        .banner-background {
            clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
        }
    </style>
</head>

<body>

    <!-- Navigation bar -->
    <%@include file="normal_navbar.jsp" %>

    <!-- Banner Section -->
    <div class="container-fluid p-0 m-0">
        <div class="jumbotron primary-background text-white banner-background">
            <div class="container">
                <h3 class="display-3">Welcome to TechBlog</h3>

                <p>
                    Welcome to TechBlog - your one-stop destination for everything tech!
                    Dive into the latest trends, tutorials, and insights on programming languages,
                    project development, data structures, core computer science concepts, and more.
                </p>
                <p>
                    Whether you're a student, developer, or tech enthusiast, TechBlog is here to empower
                    your learning journey with practical articles and real-world examples. Stay curious. Stay updated.
                </p>

                <button class="btn btn-outline-light btn-lg">
                    <span class="fa fa-user-plus"></span> Start! It's Free
                </button>
                <a href="login_page.jsp" class="btn btn-outline-light btn-lg">
                    <span class="fa fa-user-circle fa-spin"></span> Login
                </a>
            </div>
        </div>
    </div>

    <!-- Cards Section -->
    <div class="container">

        <div class="row mb-2">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Java Programming</h5>
                        <p class="card-text">Master the fundamentals of Java, from OOP principles to multithreading and collections.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Web Development</h5>
                        <p class="card-text">Explore HTML, CSS, JavaScript, and popular frameworks like Bootstrap and React.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Data Structures</h5>
                        <p class="card-text">Understand stacks, queues, trees, and graphs with real-world coding examples.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Database Management</h5>
                        <p class="card-text">Learn SQL, relational models, normalization, and integration with backend apps.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Software Engineering</h5>
                        <p class="card-text">Explore SDLC, Agile methodology, version control, and design patterns in projects.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Tech Tips & Tricks</h5>
                        <p class="card-text">Boost productivity with coding shortcuts, tools, and hidden features every dev should know.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</body>
</html>
