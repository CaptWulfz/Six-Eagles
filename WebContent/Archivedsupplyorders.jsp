<%-- 
    Document   : ArchivedClientOrders
    Created on : 02 20, 18, 1:12:56 AM
    Author     : Joshua Sultan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dao.supplyordersdao" %>
<%@page import= "model.supplyorders" %>
<%@page import = "model.suppliers" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<% 

ArrayList<supplyorders>sord = (ArrayList<supplyorders>) request.getAttribute("supplyOrders");
ArrayList<suppliers>sup = (ArrayList<suppliers>) request.getAttribute("suppliersList");

%>

<html>	
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
			<ol class="breadcrumb">
		   	    <li><a href="/Six_Eagles/home">Home</a></li>		
			    <li><a href = "/Six_Eagles/manageOrders">Client</a></li>
				<li><a href = "/Six_Eagles/viewArchivedClientOrders">Archived Client Orders</a></li>
				<li><a href = "/Six_Eagles/viewSupplyOrders">Supplier</a></li>
	            <li><a class = "active">Archived supply Orders</a></li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Orders
				</div>
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