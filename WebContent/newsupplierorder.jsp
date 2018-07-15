<%-- 
    Document   : newsupplierorder
    Created on : 02 20, 18, 2:24:41 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">  
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="home.jsp">Home</a></li>		
		    <li><a href = "neworder.jsp">Client</a></li>
			<li><a class = "active">Supplier</a></li>
		</ol>
			<div class="panel panel-default" style="width: 100%; margin-left: 0%;">
				<div class="panel-heading">
					New Supplier Order
				</div>
				<div class="messages">
						
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="
								</select>
							</div>
						</div>
						<button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Next Step</button></a>
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
