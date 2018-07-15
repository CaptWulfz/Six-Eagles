<%-- 
    Document   : orders
    Created on : 02 20, 18, 2:27:43 AM
    Author     : Joshua Sultan
--%>

<%@page import="dao.orderdetailsdao"%>
<%@page import="model.OrderDetails"%>
<%@page import = "dao.ClientOrderdao" %>
<%@page import= "model.Orders" %>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
int code = (Integer)request.getAttribute("codew");

ArrayList<OrderDetails>orderdetails = orderdetailsdao.vieworderdetails(code);

%>
<html>	
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="home.jsp">Home</a></li>
		</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Orders
				</div>
				<div class="panel-body">
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
                                                            <th><center>Purchase Order No.</center></th>
                                                            <th><center>Product Code</center></th>
                                                            <th><center>Unit Price</center></th>
                                                            <th><center>Quantity Ordered</center></th>
                                                            <!--<th><center>Comments</center></th>-->
							</tr>
                                                        
                                                        <%
                                                        for(OrderDetails o : orderdetails){
                                                         %>
                                                         
                                                         <tr>
                                                    <td><center><%=o.getPurchaseOrderNum()%></center></td>
                                                    <td><center><%=o.getProductCode()%></center></td>
                                                    <td><center><%=o.getUnitprice()%></center></td>
                                                    <td><center><%=o.getQtyOrdered()%></center></td>
                                        <td><center><a href="vieworderdetails?code=<%=o.getPurchaseOrderNum()%>"><button class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View Order Details</button></a></center><td>
                                                </tr>
                                                <%}%>
						</thead>
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
