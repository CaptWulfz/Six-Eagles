<%-- 
    Document   : header
    Created on : 02 20, 18, 1:29:07 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Users" %>
<!DOCTYPE html>
<html>
<head>

	<title>Inventory Management System</title>

	<!-- bootstrap -->
	<link rel="stylesheet" href="assests/bootstrap/css/bootstrap.min.css">
	<!-- bootstrap theme-->
	<link rel="stylesheet" href="assests/bootstrap/css/bootstrap-theme.min.css">
	<!-- font awesome -->
	<link rel="stylesheet" href="assests/font-awesome/css/font-awesome.min.css">

  <!-- custom css -->
  <link rel="stylesheet" href="custom/css/custom.css">

	<!-- DataTables -->
  <link rel="stylesheet" href="assests/plugins/datatables/jquery.dataTables.min.css">

  <!-- file input -->
  <link rel="stylesheet" href="assests/plugins/fileinput/css/fileinput.min.css">

  <!-- jquery -->
	<script src="assests/jquery/jquery.min.js"></script>
  <!-- jquery ui -->  
  <link rel="stylesheet" href="assests/jquery-ui/jquery-ui.min.css">
  <script src="assests/jquery-ui/jquery-ui.min.js"></script>

  <!-- bootstrap js -->
	<script src="assests/bootstrap/js/bootstrap.min.js"></script>
	

</head>
<body>


	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!-- <a class="navbar-brand" href="#">Brand</a> -->
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      

      <ul class="nav navbar-nav navbar-right">        
      	<li id="navDashboard"><a href="/Six_Eagles/home"><i class="glyphicon glyphicon-list-alt"></i>  Dashboard</a></li>    
        
        <li id="navClients"><a href="/Six_Eagles/clients"><i class="glyphicon glyphicon-apple"></i>  Clients</a></li> 
        
        <li id="navSuppliers"><a href="/Six_Eagles/suppliers"><i class="glyphicon glyphicon-apple"></i>  Suppliers</a></li> 
        
        <li id="navBrand"><a href="/Six_Eagles/ingredients"><i class="glyphicon glyphicon-apple"></i>  Ingredients</a></li> 
              

  <!--      <li id="navCategories"><a href="categories.jsp"> <i class="glyphicon glyphicon-th-list"></i> Category</a></li>       --> 

        <li id="navProduct"><a href="/Six_Eagles/inventory"> <i class="glyphicon glyphicon-ruble"></i> Product </a></li>     

        <li class="dropdown" id="navOrder">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="glyphicon glyphicon-shopping-cart"></i> Orders <span class="caret"></span></a>
          <ul class="dropdown-menu">            
            <li id="topNavAddOrder"><a href="/Six_Eagles/newClientOrder"> <i class="glyphicon glyphicon-plus"></i> Add New Client Order</a></li>
            <li id="topNavAddOrder"><a href="/Six_Eagles/newSupplierOrder"> <i class="glyphicon glyphicon-plus"></i> Add New Supplier Order</a></li>            
            <li id="topNavManageOrder"><a href="orders.jsp"> <i class="glyphicon glyphicon-edit"></i> Manage Orders</a></li>            
          </ul>
        </li> 
		
        <li id="navReport"><a href="generateReports.jsp"> <i class="glyphicon glyphicon-check"></i> Report </a></li>

        <li class="dropdown" id="navSetting">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="glyphicon glyphicon-user"></i> <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <% Users user = (Users) session.getAttribute("loginUser");
    		if (user != null) { 
    			if (user.getPosition().equals("Admin")) { %>
					<li id ="topNavAddUser"><a href = "/Six_Eagles/createUser"><i class="glyphicon glyphicon-plus"></i>Create Users</a></li>
			 	<% } %>
            <li id="topNavSetting"><a href="setting.jsp"> <i class="glyphicon glyphicon-wrench"></i> Setting</a></li>            
            <li id="topNavLogout"><a href="/Six_Eagles/logOut"> <i class="glyphicon glyphicon-log-out"></i> Logout</a></li>            
          <% } else { %>
          	<li id = "topNavLogin"><a href = "/Six_Eagles/login"><i class="glyphicon glyphicon-log-out"></i> Login</a>
          	<% } %>
          </ul>
        </li>        
               
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
	</nav>

	<div class="container">