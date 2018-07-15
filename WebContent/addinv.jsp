<%-- 
    Document   : addinv
    Created on : 02 20, 18, 1:10:23 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
	<head>
		<title>Eagle's Eye</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	</head>
	
	<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<script>
		$(document).ready(function(){
		  var date_input=$('input[name="date"]'); //our date input has the name "date"
		  var container=$('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
		  var options={
			format: 'mm-dd-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		  };
		  date_input.datepicker(options);
		})
	</script>
		
		<div class="container-fluid" style="height: 100px;
									background-color:white;">
			<div class="row">
				<div class="col-sm-6">
					<h1 style="margin-top: 30px;
						margin-left: 10px;
						font-family: Tahoma;">Eagle's Eye <small>INTEGRATED MANAGEMENT SYSTEM</small></h1>
				</div>
			</div>
		</div>

		<nav class="navbar" data-spy="affix" data-offset-top="97">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle glyphicon glyphicon-menu-hamburger" data-toggle="collapse" data-target="#navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>                        
					</button>
				</div>
				<div>
					<div class="collapse navbar-collapse" id="navigation">
						<ul class="nav navbar-nav">
							<li><a href="home.jsp">Home</a></li>
							<li><a class = "active" href="inventory.jsp">Products</a></li>
							<li><a href="ingredients.jsp">Ingredients</a></li>
							<li><a href="orders.jsp">Orders</a></li>
							<li><a href="reports.jsp">Reports</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> User</a></li>
							<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>    

		<div class="area container-fluid">
			<div class="panel panel-default" style="width: 70%; margin-left: 15%;">
				<div class="panel-heading">
					New Item
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Item Name</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" id="col1" style="width: 150px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Quantity</label>
							<div class="col-sm-7">
								<input type="number" class="ipsum form-control" id="col2" style="width: 150px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col3">Threshold</label>
							<div class="col-sm-7">
								<input type="number" class="dolor form-control" id="col3" style="width: 150px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col4">Unit</label>
							<div class="col-sm-7">
								<input type="text" class="sit form-control" id="col4" style="width: 150px;">
							</div>
						</div>
					</form>
					<a href="inventory.jsp"><button type="submit" class="btn btn-default" style="margin-left: 35%;">Submit</button></a>
					<a href="inventory.jsp"><button type="button" class="btn btn-default">Cancel</button></a>
				</div>
			</div>
		</div>

	</body>
	
	<style>
		body {
			position: relative; 
			background-color: #1E88E5;
		}
		
		.active {
			color: black;
		}

		.affix {
			top:0;
			width: 100%;
			z-index: 9999;
		}

		.navbar {
			margin-bottom: 0px;
			width: 100%;
			background-color: white;
		}
		
		.affix ~ .container-fluid {
			position: relative;
			top: 50px;
		}

		.area {
			padding-top: 50px;
			padding-left: 200px;
			padding-right: 200px;
			background-color: #1E88E5;
			height: 100%;
		}
		
		.panel-body {
			width: 100%;
			margin-left: 0px;
		}
		
		.form-horizontal .lorem, .ipsum, .dolor, .sit, .amet {
			margin-left: 0px;
			width: 75%;
		}
		
		.btn {
			margin-top: 15px;
			margin-right: 5px;
		}
	</style>
</html>
