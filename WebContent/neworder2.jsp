<%-- 
    Document   : neworder
    Created on : 02 20, 18, 2:22:54 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.clientdao" %>
<%@page import = "model.Client" %>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.productdao" %>
<%@page import= "model.product" %>
<%@page import = "dao.ClientOrderdao" %>
<%@page import= "model.Orders" %>
<%@page import = "temporary_models.CartItem" %>

<!DOCTYPE html>
<%
    ArrayList<Client>cl=clientdao.viewClientactive();
    ArrayList<product>prod = productdao.viewproductactive();
    ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
     
%>

<html>
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<script>
		$(document).ready(function(){
		  var date_input=$('input[name="date"]'); //our date input has the name "date"
		  var container=$('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
		  var options={
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
		  };
		  date_input.datepicker(options);
		})
	</script>   
		<div class="area container-fluid">
			<ol class="breadcrumb">
		   	    <li><a href="/Six_Eagles/home">Home</a></li>		
			    <li><a class = "active">Client</a></li>
				<li><a href = "/Six_Eagles/newSupplierOrder">Supplier</a></li>
			</ol>
		
			<div id = "cartOptions" class="panel panel-default" style="width: 49%; margin-left: 0%;">
				<div class="panel-heading">
					New Client Order
				</div>
				<div class="messages">
					<div  class="panel-body">
						<form class="form-horizontal" action="newClientOrderDetails" method="post" id="addOrders">
							
								
							<div class="form-group">
								<label class="control-label col-sm-4" for="col2">Product:</label>
								<div class="col-sm-7">
									<select class="form-control" id="productCode" name="productCode" style = "width : 220px">
	                                                                     <%
	                                                    
	                                                    for(product p : prod){
	                                                        
	                                                %>
										<option value="<%=p.getProductcode()%>"><%=p.getProductname()%></option>
										<%}%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="col3">Quantity:</label>
								<div class="col-sm-7">
									<input type="number" min = 0 class="dolor form-control" id="quantity" name="quantity" placeholder="Quantity" value = 0 style="margin-bottom: 5px; width: 50%;">
								</div>
							
								<button type="submit" name = "submitButton" value = "addToCart" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button>
								<button type="submit" name = "submitButton" value = "checkout" class="btn btn-default">Done</button>
							</div>
						</form>                                            
	                   
					</div>
				</div>
			</div>
			
			<div id = "cart" class="panel panel-default" style="width: 49%; margin-left: 0%;">
				<div class="panel-heading">
					Cart
				</div>
				<div class="messages">
						
					<div class="panel-body">
						<table id = "orderTable">
							<tr>
								<th>Product Name</th>
								<th>Quantity</th>
								<th>Price per Piece</th>
								<th>Total Price</th>
							</tr>
							<% double total = 0;
							for (CartItem item: cart) { %>
								<tr>
									<th><%=item.getName() %></th>
									<th><%=item.getQuantity() %></th>
									<th><%=item.getPricePerPiece() %></th>
									<th><%=item.getTotalPrice() %></th>
									<td><center><button type = "submit" name = "submitButton" class = "btn btn-default"></button></center></td>
								</tr>	
							<%  	total += item.getTotalPrice();
								} %>
							<tr>
								<th colspan = "3"> <strong>Running Total:</strong> </th>
								<th><%=total %></th>
							<tr>
						</table>
					</div>
					<form action = "newClientOrderDetails" method = "post">
						<button id = "clearButton" type="submit" name = "submitButton" value = "Remove" class="btn btn-default">Clear Cart</button>
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
		
		#clearButton {
			margin-left: 15px;
			margin-top: 0px;
			margin-bottom: 10px;
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
		
		#orderTable tr th {
			border: 1px solid black;
			padding: 5px;
			text-align: center;
		}
		
		#orderTable {
			width: 100%;
		}

		.area {
			padding-top: 50px;
			padding-left: 180px;
			padding-right: 180px;
			background-color: #1E88E5;
			height: 100%;
		}
		
		.panel-body {
			width: 100%;
			margin-left: 0px;
			
		}
		
		#cartOptions {
			float: left;
			margin-right: 10px;
		}
		
		#cart {
			float: left;
			margin-left: 10px;
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