<%-- 
    Document   : newsupplierorder2
    Created on : 02 20, 18, 2:25:19 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "model.suppliers" %>
<%@page import = "model.rawmaterials" %>
<%@page import = "model.supplyorders" %>
<%@page import = "temporary_models.SupplyOrderItem" %>
<!DOCTYPE html>

<% ArrayList<suppliers> suppliersList = (ArrayList<suppliers>) request.getAttribute("suppliersList");
   ArrayList<rawmaterials> rawMaterialsList = (ArrayList<rawmaterials>) request.getAttribute("rawMaterialsList");
   ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
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
	   	    <li><a href="home.jsp">Home</a></li>		
		    <li><a href = "neworder.jsp">Client</a></li>
			<li><a class = "active">Supplier</a></li>
		</ol>
			<div id = "supplierOrder" class="panel panel-default" style="width: 48%; margin-left: 0%;">
				<div class="panel-heading">
					New Supplier Order
				</div>
				<div class="messages">
						
				<div class="panel-body">
					<form class="form-horizontal" action="manageSupplyOrder" method="post" id="addOrders">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Supplier Name:</label>
							<div class="col-sm-7">
								<select class = "form-control" id = "supplierName" name = "supplierName" style = "width: 150px">
									<% for (suppliers s: suppliersList) { %>
											<option value = "<%=s.getSupplierID()%>"><%= s.getSupplierName() %></option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Supply Order Number:</label>
							<div class="col-sm-7">
								<input type="number" class="lorem form-control" name = "supplyOrder" id="col1" style="width: 150px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Ingredient Brand:</label>
							<div class="col-sm-7">
								<select class="form-control" id="ingredientCode" name="rawmCode" style = "width : 150px">
									<% for (rawmaterials r : rawMaterialsList) { %>
										<option value = "<%=r.getRawMaterialCode()%>"><%=r.getIngredientBrand() %></option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Quantity:</label>
							<div class="col-sm-7">
								<input type="number" class="ipsum form-control" id="quantity" name = "quantity" style="width: 150px;">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-5" for="col3">Date Ordered:</label>
							<div class="col-sm-7">
								<input type="text" class="dolor form-control" id="rdate" name="orderDate" placeholder="yyyy-mm-dd" style="margin-bottom: 5px; width: 150px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col4">Delivery Date:</label>
							<div class="col-sm-7">
								<input type="text" class="sit form-control" id="ddate" name="deliveryDate" placeholder="yyyy-mm-dd" style="margin-bottom: 5px; width: 150px;">
							</div>
						</div>
						<button type="submit" name = "submit" value = "addToOrder" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button></a>
						<button type="submit" name = "submit" value = "checkout" class="btn btn-default">Done</button>
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
								<th>Supplier ID</th>
								<th>Supply Order Num</th>
								<th>Order Date</th>
								<th>Delivery Date</th>
							<tr>
							<% for (SupplyOrderItem cartItem: supplyOrdersCart) { 
								supplyorders item = cartItem.getSupplyOrders();%>
								<tr>
									<th><%=item.getSupplierName() %></th>
									<th><%=item.getSupplyOrderNum() %></th>
									<th><%=item.getOrderDate() %></th>
									<th><%=item.getDeliveryDate() %><th>
								</tr>	
							<% } %>
						</table>
					</div>
					<form action = "newClientOrderDetails" method = "post">
						<button id = "clearButton" type="submit" name = "submitButton" value = "Remove" class="btn btn-default">Clear Cart</button>
					</form>
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
		
		#clearButton {
			margin-left: 15px;
			margin-top: 0px;
			margin-bottom: 10px;
		}
		
		#supplierOrder {
			float: left;
			margin-right: 10px;
		}
		
		#cart {
			float: left;
			margin-left: 10px;
		}
		
		#orderTable tr th {
			border: 1px solid black;
			padding: 5px;
			text-align: center;
		}
		
		#orderTable {
			width: 100%;
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