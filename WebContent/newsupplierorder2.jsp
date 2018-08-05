<%-- 
    Document   : newsupplierorder2
    Created on : 02 20, 18, 2:25:19 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "model.suppliers" %>
<%@page import = "model.ingredients" %>
<%@page import = "model.supplyorders" %>
<%@page import = "temporary_models.SupplyOrderItem" %>
<!DOCTYPE html>

<% ArrayList<suppliers> suppliersList = (ArrayList<suppliers>) request.getAttribute("suppliersList");
   ArrayList<ingredients> ingrList = (ArrayList<ingredients>) request.getAttribute("ingrList");
   ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
%>

<html>
    <jsp:include page="header.jsp"/>
	<body onload = "tryAlert()" data-spy="scroll" data-target=".navbar" data-offset="50">

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
		
		function tryAlert () {
		 	<% String message = (String) request.getAttribute("message");
				if (message != null) { %>
					alert("<%=message %>");
				<% } %>
		}
		
		function changeSupplierStock() {
			var form = document.getElementById("addOrders");
			
			form.submit();
		}
	</script>   
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="/Six_Eagles/home">Home</a></li>		
		    <li><a href = "/Six_Eagles/newClientOrder">Client</a></li>
			<li><a class = "active">Supplier</a></li>
		</ol>
			<div id = "supplierOrder" class="panel panel-default" style="width: 46%; margin-left: 0%;">
				<div class="panel-heading">
					New Supplier Order
				</div>
				<div class="messages">
						
				<div class="panel-body">
					<form class="form-horizontal" action="manageSupplyOrder" method="post" id="addOrders">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Supplier Name:</label>
							<div class="col-sm-7">
								<select onchange = "changeSupplierStock()" class = "form-control" id = "supplierName" name = "supplierName" style = "width: 150px">
									<%	int index = (Integer) request.getAttribute("index"); 
										int i = 0;
										for (suppliers s: suppliersList) { %>
											<option value = "<%=s.getSupplierID()%>" <% if (index == i) { out.print("selected"); } %>><%= s.getSupplierName() %></option>
									<% 		i++;
										} %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Supply Order Number:</label>
							<div class="col-sm-7">
								<input type="number" mi n = 0 class="lorem form-control" name = "supplyOrder" id="col1" min = 0 value = 1 style="width: 150px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Ingredient Name:</label>
							<div class="col-sm-7">
								<select class="form-control" id="ingredientCode" name="ingrCode" style = "width : 150px">
									<% for (ingredients ingr: ingrList) { %>
										<option value = "<%=ingr.getIngredientCode()%>"><%=ingr.getIngredientName() %></option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Quantity:</label>
							<div class="col-sm-7">
								<input type="number" min = 0 class="ipsum form-control" id="quantity" name = "quantity" value = 1 min = 1 style="width: 150px;" required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-5" for="col3">Date Ordered:</label>
							<div class="col-sm-7">
								<input type="date" class="dolor form-control" id="rdate" name="orderDate" placeholder="yyyy-mm-dd" value = <%=request.getAttribute("dateToday") %> style="margin-bottom: 5px; width: 150px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col4">Delivery Date:</label>
							<div class="col-sm-7">
								<input type="date" class="sit form-control" id="ddate" name="deliveryDate" placeholder="yyyy-mm-dd" value = <%=request.getAttribute("dateTomorrow") %> style="margin-bottom: 5px; width: 150px;" required>
							</div>
						</div>
						<button type="submit" name = "submitBtn" value = "addToOrder" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button></a>
						<button type="submit" name = "submitBtn" value = "checkout" class="btn btn-default">Done</button>
					</form>
				</div>
			</div>
		</div>
		
		<div id = "cart" class="panel panel-default" style="width: 52%; margin-left: 0%;">
				<div class="panel-heading">
					Cart
				</div>
				<div class="messages">
						
					<div class="panel-body">
						<table id = "orderTable">
							<tr>
								<th>Supplier ID</th>
								<th>Supply Order Num</th>
								<th>Ingredient Name</th>
								<th>Order Date</th>
								<th>Delivery Date</th>
							<tr>
							<% for (int j = 0; j < supplyOrdersCart.size(); j++ ) {
								SupplyOrderItem cartItem = supplyOrdersCart.get(j);
								supplyorders item = cartItem.getSupplyOrders();
								ingredients ingr = cartItem.getIngredient();%>
								<tr>
									<th><%=item.getSupplierName() %></th>
									<th><%=item.getSupplyOrderNum() %></th>
									<th><%=ingr.getIngredientName()%></th>
									<th><%=item.getOrderDate() %></th>
									<th><%=item.getDeliveryDate() %></th>
									<td>
										<form method = "post" action = "/Six_Eagles/removeSupplyOrder">
											<center><button type = "submit" name = "submitButton" value = <%=j %> class = "btn btn-default"><img src = "images/Minus-Icon.png" height = "15" width = "15"></button></center>
										</form>
									</td>
								</tr>	
							<% } %>
						</table>
					</div>
					<form action = "manageSupplyOrder" method = "post">
						<button id = "clearButton" type="submit" name = "submit" value = "Remove" class="btn btn-default">Clear Cart</button>
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
		
		td {
			padding: 5px;
			padding-bottom: 10px;
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