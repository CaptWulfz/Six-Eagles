<%-- 
    Document   : home
    Created on : 02 20, 18, 1:04:30 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Users" %>
<%@page import="model.suppliers"%>
<%@page import="model.supplyorders"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
ArrayList<supplyorders>sord = (ArrayList<supplyorders>) request.getAttribute("supplyOrders");
ArrayList<suppliers>sup = (ArrayList<suppliers>) request.getAttribute("suppliersList");

ArrayList<supplyorders>sordRange = (ArrayList<supplyorders>) request.getAttribute("supplyOrdersRange");
ArrayList<suppliers>supRange = (ArrayList<suppliers>) request.getAttribute("suppliersListRange");

%>
<jsp:include page="header.jsp"/>
<html>
    <head>
		<title>Eagle's Eye</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
    <style type="text/css">
	.ui-datepicker-calendar {
		display: none;
	}
</style>

<!-- fullCalendar 2.2.5-->
    <link rel="stylesheet" href="assests/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="assests/plugins/fullcalendar/fullcalendar.print.css" media="print">

<body onload = "displayMessage()">
	
		
		
	
		<div class="col-md-4">
			<div class="card">
			  <div class="cardHeader" style="background-color:#245580;">
				<h3>Greetings,</h3>
			    <h1>
			    <% 	Users user = (Users) session.getAttribute("loginUser"); 
			    	if (user != null) 
			    		out.write(user.getUsername());
			    	else { %>
			    	User
			    	<% } %>
			    </h1>
			  </div>
	
			  <div class="cardContainer" style = "background-color: #FFFFFF;">
			    <p>Nice	to meet you!</p>
			  </div>
			</div> 
			<br/>
			<div class="card">
			  <div class="cardHeader" style="background-color:#245580;">
			    <h1></h1>
			  </div>
	
			  <div class="cardContainer" style = "background-color: #FFFFFF;">
			    <p></p>
			  </div>
			</div> 
			
	
			
	
		</div>
	
		<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading"> <i class="glyphicon glyphicon-calendar"></i> Due Today: <%=request.getAttribute("dateToday") %></div>
				<div class="panel-body"> 
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
								<th><center>Supplier Order No. </center></th>
								<th><center>Supplier</center></th>
								<th><center>Delivery Receipt No.</center></th>
								<th><center>Order Date</center></th>
								<th><center>Delivery Date</center></th>
								<th><center>Status</center></th>
							</tr>
                                                        
                             <%for(int i = 0; i < sord.size(); i++) { 
                               	 supplyorders s = sord.get(i);
                               	 suppliers sp = sup.get(i);				%>
	                             <tr>
	                                 <td><center><%=s.getSupplyOrderNum()%></center></td>
	                                 <td><center><%=sp.getSupplierName() %></center></td>
	                                 <td><center><%=s.getDeliveryReceiptNo()%></center></td>
	                                 <td><center><%=s.getOrderDate()%></center></td>
	                                 <td><center><%=s.getDeliveryDate()%></center></td>
	                                 <td><center><%=s.getStatusDetails()%></center></td>
	             					 <td>
	             					 	<form method = "post" action = "/Six_Eagles/viewsupplyorderdetails">
	             					 		<center><button type = "submit" name = "submitBtn" value = <%=s.getSupplyOrderNum()%> class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i> View Supply Order Details</button></center>
	                             		</form>
	                             	<td>
	                             </tr>
                             <% } %>
						</thead>
					</table>
				</div>	
			</div>
		</div> <!--/row-->
			
			<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading"> <i class="glyphicon glyphicon-calendar"></i> Due From: <%=request.getAttribute("dateToday") %> To: <%=request.getAttribute("dateNextWeek") %></div>
				<div class="panel-body">
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
								<th><center>Supplier Order No. </center></th>
								<th><center>Supplier</center></th>
								<th><center>Delivery Receipt No.</center></th>
								<th><center>Order Date</center></th>
								<th><center>Delivery Date</center></th>
								<th><center>Status</center></th>
							</tr>
                                                        
                             <%	for(int i = 0; i < sordRange.size(); i++) { 
                               	 supplyorders s = sordRange.get(i);
                               	 suppliers sp = supRange.get(i);				%>
	                             <tr>
	                                 <td><center><%=s.getSupplyOrderNum()%></center></td>
	                                 <td><center><%=sp.getSupplierName() %></center></td>
	                                 <td><center><%=s.getDeliveryReceiptNo()%></center></td>
	                                 <td><center><%=s.getOrderDate()%></center></td>
	                                 <td><center><%=s.getDeliveryDate()%></center></td>
	                                 <td><center><%=s.getStatusDetails()%></center></td>
	             					 <td>
	             					 	<form method = "post" action = "/Six_Eagles/viewsupplyorderdetails">
	             					 		<center><button type = "submit" name = "submitBtn" value = <%=s.getSupplyOrderNum()%> class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i> View Supply Order Details</button></center>
	                             		</form>
	                             	<td>
	                             </tr>
                             <% } %>
						</thead>
					</table>
				</div>	
			</div>
		</div>
</body>
<!-- fullCalendar 2.2.5 -->
<script src="assests/plugins/moment/moment.min.js"></script>
<script src="assests/plugins/fullcalendar/fullcalendar.min.js"></script>


<script type="text/javascript">
	$(
      <% String message = (String) request.getAttribute("message");
	   System.out.println("THE MESSAGE IS: " + message);
	   if (message != null) { %>
	   		alert("<%=message%>");
	  <% } %>

    });
	

		
	

</script>
	<style>
		body {
			position: relative;
			background-color: #1E88E5;
		}


	</style>
</html>
