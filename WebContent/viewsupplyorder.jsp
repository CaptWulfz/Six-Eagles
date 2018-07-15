<%-- 
    Document   : viewsupplyorder
    Created on : 02 20, 18, 2:37:12 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.Supplierdao"%>
<%@page import="model.suppliers"%>
<%@page import="model.supplyorderdetails"%>
<%@page import="dao.supplyorderdetailsdao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
    int code = (Integer)request.getAttribute("codew");
    
    ArrayList<supplyorderdetails>sord=supplyorderdetailsdao.viewsupplyorderdetails(code);
    ArrayList<suppliers>sup=Supplierdao.viewSupplier();
    
%>

<html>	
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="home.jsp">Home</a></li>		
		    <li><a href = "orders.jsp">Client</a></li>
			<li><a class = "active">Supplier</a></li>
		</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Orders
				</div>
				<div class="panel-body">
                                    	<div class="div-action pull pull-right" style="padding-bottom:20px;">
                                            <button class="btn btn-default button1" data-toggle="modal" data-target="#addSupplyOrderModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Supply Order</button>
                                        </div> <!-- /div-action -->
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
								<th><center>Supplier ID </center></th>
								<th><center>Delivery Receipt No.</center></th>
								<th><center>Order Date</center></th>
								<th><center>Delivery Date</center></th>
								<th><center>Status</center></th>
								<th><center>Comments</center></th>
							</tr>
                                                        
                                                        <%for(supplyorderdetails s : sord)
                                                          
                                                        
                                                        {
                                                        
                                                                                                                                                                                
                                                    
                                                         %>
                                                        <tr>
                                                            <td><center><%=s.getRawMaterialCode()%></center></td>
                                                            <td><center><%=s.getQuantity()%></center></td>
                                                            <td><center><%=s.getUnit()%></center></td>
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
