<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.ingredients" %>
<%@ page import = "model.suppliers"  %>
<%@ page import = "model.SupplierStock" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	ArrayList<ingredients> ingrList = (ArrayList<ingredients>) request.getAttribute("ingrList");
	ArrayList<SupplierStock> stockList = (ArrayList<SupplierStock>) request.getAttribute("stockList");
	suppliers supplier = (suppliers) request.getAttribute("supplier");
%>
<html>
	<jsp:include page="header.jsp"/>
	<script src="jquery-3.3.1.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Six Eagles</title>
	</head>
	
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class = "area container-fluid">
			<ol class="breadcrumb">
		   	    <li><a href="/Six_Eagles/home">Home</a></li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Ingredient Stock of <%=supplier.getSupplierName()%> from <%=supplier.getAddress() %>
				</div>
				<div class="panel-body">
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
	                            <th><center>Ingredient Name</center></th>
	                            <th><center>Unit of Measurement</center></th>
	                            <th><center>Price</center></th>
	                            <!--<th><center>Comments</center></th>-->
							</tr>
                            	<% for(int j = 0;j < ingrList.size(); j++) { 
                            		ingredients i = ingrList.get(j);			
                            		SupplierStock ss = stockList.get(j);	%>
                               		<tr>
                            			<td><center><%=i.getIngredientName() %></center></td>
                            			<td><center><%=i.getUnitOfMeasurement()%></center></td>
                            			<td><center><%=ss.getIngredientPrice() %></center></td>
                            			<td>
                            				<form method = "post" action = "/Six_Eagles/removeStockIngredient">
												<center><button type = "submit" name = "submitButton" value = <%=ss.getSupplierStockID() %> class = "btn btn-default"><img src = "images/Minus-Icon.png" height = "15" width = "15"></button></center>
											</form>
                            			</td>
                      				</tr>
                                 <% } %>
						</thead>
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
			width: 110%;
			padding-right: 90px;
		}
		
		td a {
			display: block;
			color: black;
		}
		
		.row {
			width: 95%;
		}
		
		td a:hover {
			text-decoration: none;
			color: black;
		}
	</style>
</html>