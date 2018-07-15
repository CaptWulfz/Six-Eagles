<%-- 
    Document   : vieworders
    Created on : 02 20, 18, 2:36:25 AM
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
		    <li><a class = "active">Client</a></li>
			<li><a href = "ArchivedClientOrders.jsp">Archived Client Orders</a></li>
			<li><a href = "supplyorders.jsp">Supplier</a></li>
		</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					<b> View Order </b>
				</div>
				<div class="panel-body">
					<table class="table table-hover" align = "center">
						
						<tbody>
							
						
						</tbody>
					</table>
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
			width: 90%;
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
			padding-left: 10px;
			background-color: #1E88E5;
			height: 100%;
			width: 50%;
			padding-right: 90px;
		}
		
		td a {
			display: block;
			color: black;
		}
		
		.row {
			width: 50%;
		}
		
		td a:hover {
			text-decoration: none;
			color: black;
		}
	</style>
</html>
