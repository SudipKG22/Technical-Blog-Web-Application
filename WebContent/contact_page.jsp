<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Contact - Tech Blogs</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      background-color: #3d7f7f;
      font-family: 'Segoe UI', sans-serif;
      color: #fff;
    }

    .contact-container {
      display: flex;
      justify-content: space-between;
      padding: 80px 10%;
      flex-wrap: wrap;
    }

    .contact-info, .contact-address {
      flex: 1 1 300px;
      margin: 20px;
    }

    h2 {
      color: #f9f9f9;
      font-size: 32px;
      margin-bottom: 20px;
      font-weight: 500;
      letter-spacing: 1px;
    }

    .contact-section {
      margin-bottom: 25px;
    }

    .contact-section h4 {
      font-size: 20px;
      font-weight: 600;
      margin-bottom: 5px;
    }

    .contact-section p,
    .contact-address p {
      color: #000;
      line-height: 1.6;
      font-size: 20px;
    }

    a {
      color: yellow;
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }

    .contact-section i {
      margin-right: 8px;
      color: #a0e0a0;
    }

    .contact-address i {
      color: lightgreen;
      margin-right: 8px;
    }

    .primary-background {
      background-color: #343a40 !important;
    }

    @media (max-width: 768px) {
      .contact-container {
        flex-direction: column;
        padding: 40px 20px;
      }
    }
  </style>
</head>

<body>

  <!-- ✅ NAVBAR -->
  <%@include file="normal_navbar.jsp" %>

  <!-- ✅ CONTACT SECTION -->
  <div class="contact-container">
    <div class="contact-info">
      <h2>Contact us</h2>

      <div class="contact-section">
        <h4>Email</h4>
        <p><i class="fas fa-envelope"></i>Email us at 
          <a href="mailto:sudipkrghosh.cu@gmail.com">sudipkrghosh.cu@gmail.com</a>
        </p>
      </div>

      <div class="contact-section">
        <h4>LinkedIn</h4>
        <p><i class="fab fa-linkedin"></i>Connect us at 
          <a href="https://www.linkedin.com/in/sudip-kr-ghosh-982006369" target="_blank">Sudip Kr. Ghosh</a>
        </p>
      </div>

      <div class="contact-section">
        <h4>Instagram</h4>
        <p><i class="fab fa-instagram"></i>Connect us at 
          <a href="https://www.instagram.com/sudip_kg_21/" target="_blank">sudip_kg_21</a>
        </p>
      </div>

      <div class="contact-section">
        <h4>GitHub</h4>
        <p><i class="fab fa-github"></i>Explore our projects at 
          <a href="https://github.com/SudipKG22" target="_blank">SudipKG22</a>
        </p>
      </div>
    </div>

    <div class="contact-address">
      <h2>Our address</h2>
      <p><i class="fas fa-map-marker-alt"></i>H106, Sukantanagar<br/>
         P.O. Bidhannagar,<br/>
         Kolkata, 700098
      </p>
    </div>
  </div>

  <!-- ✅ BOOTSTRAP JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
