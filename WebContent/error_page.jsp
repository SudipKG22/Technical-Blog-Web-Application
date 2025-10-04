<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR!</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Custom CSS -->
    	<link rel="stylesheet" href="css/error.css" type="text/css"/>

    </head>
    <body>
        <div class="container text-center">
            <img src="img/error.png" class="img-fluid" >
            <h3 class="display-3">Oops! Something went wrong...</h3>
        	<p class="lead">An unexpected error has occurred. Please try again later.</p>
            
            <a href="index.jsp" class="btn-home"> ← Go Back to Home </a>
        </div>


    </body>
</html>