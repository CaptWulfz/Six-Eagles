<%-- 
    Document   : neworder
    Created on : 02 20, 18, 2:22:54 AM
    Author     : Joshua Sultan
--%>

<%@page import="dao.ClientOrderdao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.clientdao" %>
<%@page import = "model.Client" %>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.productdao" %>
<%@page import= "model.product" %>

<!DOCTYPE html>
<%
    ArrayList<Client>cl = (ArrayList<Client>) request.getAttribute("clientList");
	ArrayList<Client> allEntriesOfSelectedClient = (ArrayList<Client>) request.getAttribute("allEntriesOfSelectedClient");    
//ArrayList<product>prod = productdao.viewproduct();
     
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
		
		function changeAddress(){
			
			var form = document.getElementById("addOrders");
		
			form.submit();	
		}
		
	</script>   
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="home.jsp">Home</a></li>		
		    <li><a class = "active">Client</a></li>
			<li><a href = "newsupplierorder.jsp">Supplier</a></li>
		</ol>
			<div class="panel panel-default" style="width: 100%; margin-left: 0%;">
				<div class="panel-heading">
					New Client Order
				</div>
				<div class="messages">
						
				<div class="panel-body">
					<form class="form-horizontal" action="addClientOrder" method="post" id="addOrders">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Client:</label>
							<div class="col-sm-7">
								<select onchange = "changeAddress()" class="form-control" id="clientName" name="clientName" style = "width : 300px">
									<%  int selectedIndex = Integer.parseInt((String)request.getAttribute("selectedIndex"));
										int i = 0;
										for(Client c:cl) {  %>   
											<option value="<%=c.getClientName()%>" <% if (selectedIndex == i) { out.print("selected");  }%>><%=c.getClientName()%></option>
									<%		i++;
										}%>
                                                              
								</select>
							</div>
						</div>
						<div class = "form-group">
							<label class = "control-label col-sm-5" for = "col2">Address:</label>
							<div class="col-sm-7">
								<select  class = "form-control" id = "clientAddress" name = "clientAddress" style = "width: 300px">
									<% for (Client c: allEntriesOfSelectedClient) { %>
										<option value = "<%=c.getClientID() %>"><%=c.getAddress() %></option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Purchase Order Number:</label>
							<div class="col-sm-7">
								<input type="number" class="lorem form-control" name = "purchaseOrder" id="col1" style="width: 300px;">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-5" for="col3">Date Received:</label>
							<div class="col-sm-7">
								<input type="date" class="dolor form-control" id="rdate" name="orderDate" placeholder="yyyy-mm-dd" style="margin-bottom: 5px; width: 43%;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col4">Delivery Date:</label>
							<div class="col-sm-7">
								<input type="date" class="sit form-control" id="ddate" name="deliveryDate" placeholder="yyyy-mm-dd" style="margin-bottom: 5px; width: 43%;">
							</div>
						</div>
                                                                
						<button type="submit" value = "confirmOrder" name = "submitBtn" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button>
						<button type="button" class="btn btn-default">Cancel</button>
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