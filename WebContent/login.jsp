<%-- 
    Document   : login
    Created on : 02 20, 18, 1:23:31 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.Usersdao" %>
<%@page import = "model.Users" %>
<!DOCTYPE html>
<html>
  
	<head>
		<title>Eagle's Eye</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
        <body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="container-fluid" style="height: 100px; background-color: white;">
			<div class="row">
				<div class="col-sm-6">
					<h1 style="margin-top: 30px; margin-left: 10px; font-family: Tahoma;">Eagle's Eye <small>INVENTORY MANAGEMENT SYSTEM</small></h1>
				</div>
			</div>
		</div>
			<div class="area container-fluid">
			
				<div class="panel panel-default" style="width: 40%; margin-left: 15%;">
					<div class="panel-heading">
					Login
					</div>
					<div class="messages">
					</div>
				<div class="panel-body">
					<form class="form-horizontal" action="loginUser" method="post" id="loginForm">
							<div class="form-group">
								<label class="control-label col-sm-2 control label" >Username</label>
								<div class="col-sm-10">
									<b>Username: </b><input type="text" name = "username" class="form-control" id="username" placeholder="Username" autocomplete = "off">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 control label">Password</label>
								<div class="col-sm-10">
									<b>Password: </b><input type="password" name = "password" class="form-control" id="password" placeholder = "Password" autocomplete = "off">
								</div>
							</div>
							<button type="submit" name = "submit" class="btn btn-default"><i class="glyphicon glyphicon-log-in"></i> Sign in</button>
					</form>		
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
		
		.affix ~ .container-fluid {
			position: relative;
			top: 50px;
		}

		.area {
			padding-top: 80px;
			background-color: #1E88E5;
			margin-left: 20%;
		}
		
		.panel-body {
			padding-top: 50px;
			padding-bottom: 50px;			
			width: 80%;
			margin-left: 5%;
		}
		
		.btn {
			margin-left: 40%;
			margin-top: 20px;
		}
	</style>
</html>