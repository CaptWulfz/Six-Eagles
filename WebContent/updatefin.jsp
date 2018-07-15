<%-- 
    Document   : updatefin
    Created on : 02 20, 18, 2:33:33 AM
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
	</head>
	
	<body data-spy="scroll" data-target=".navbar" data-offset="50">

		<div class="container-fluid" style="height: 100px;
									background-color: white;">
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
							<li><a class="active" href="inventory.jsp">Products</a></li>
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
	<form method = "POST">
		<div class="area container-fluid">
			<div class="panel panel-default" style="width: 70%; margin-left: 15%;">
				<div class="panel-heading">
					Update Inventory
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="col1" style="margin-left: 15px;">Item</label>
							<select class="n form-control" id="col1" name ="InventoryItem">
								<option type = "number" name = "ChickenEmpanada" value = "" >Chicken Empanada</option>
							</select>
						</div>
					</form>
					<form class="form-inline">
						<div class="form-group">
							<label for="col2" style="margin-right: 15px;">Quantity</label>
							<input type="number" class="q form-control" id="col2" name ="AddInventoryNumber" value = "0">
							
						</div>
						<div class="radio">
						<label><input type="radio" name="optradio">Add</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="optradio">Remove</label>
						</div>
						<button type="submit" name = "submit" class="btn btn-default" style="margin-left: 22%;">Submit</button>
						<a href="http://localhost/Eagle/inventory.jsp"><button type="button" name = "cancel" class="btn btn-default">Cancel</button></a>
					</form>
					
				</div>
			</div>
		</div>
	</form>

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
			padding-left: 160px;
			padding-right: 160px;
			background-color: #1E88E5;
			height: 100%;
		}
		
		.panel-body {
			width: 60%;
			margin-left: 25%;
		}
		
		.form-horizontal .n {
			margin-left: 15px;
			width: 76%;
		}
		
		.form-inline .q, .u {
			width: 45%;
		}
		
		.btn {
			margin-top: 15px;
			margin-right: 5px;
		}
	</style>
</html>


