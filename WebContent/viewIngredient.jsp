<%-- 
    Document   : inventory
    Created on : 02 20, 18, 1:22:15 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.productdao" %>
<%@page import= "model.product" %>
<%@page import = "dao.ingredientsdao" %>
<%@page import= "model.ingredients" %>
<%@page import = "dao.ingredientslistsdao" %>
<%@page import= "model.ingredientslists" %>
<!DOCTYPE html>

<%
    
	product p = (product) request.getAttribute("product");
    ArrayList<ingredientslists>ilist = (ArrayList<ingredientslists>) request.getAttribute("ingrList"); 
%>

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
    
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="/Six_Eagles/home">Home</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b><%=p.getProductname() %>'s Ingredients</b></div>
			</div> <!-- /panel-heading --> 
			<div class="panel-body">			
				
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
                      		<th><center>Name</center></th>
                      		<th><center>Unit</center></th>
                      		<th><center>Amount</center></th>
						</tr>                  
                        <% for(ingredientslists in : ilist) { %>
                        	<tr>
                            	<td><center><%=in.getName()%></center></td>
                              	<td><center><%=in.getUnitOfMeasurement()%></center></td>
                              	<td><center><%=in.getAmount()%></center></td> 
                          	</tr>
                          <% } %>
					</thead>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
	      <!-- /modal-footer -->
     	</form>
	     <!-- /.form -->
    </div>
    <!-- /modal-content -->

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
			padding-left: 80px;
			padding-right: 20px;
			background-color: #1E88E5;
			height: 100%;
			width: 100%;
		}
		
		.request {
			padding-top: 50px;
			width: 100%;
			margin-left: 90px;
			width: 85%;
		}
		
		.row {
			width: 95%;
		}
		
		td a {
			display: block;
			color: black;
		}
		
		td a:hover {
			text-decoration: none;
			color: black;
		}
	</style>
</html>