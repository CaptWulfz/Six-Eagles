<%-- 
    Document   : viewsupplyorder
    Created on : 02 20, 18, 2:37:12 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.Supplierdao"%>
<%@page import="model.ingredients"%>
<%@page import="model.supplyorderdetails"%>
<%@page import="dao.supplyorderdetailsdao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
    ArrayList<supplyorderdetails>sord = (ArrayList<supplyorderdetails>) request.getAttribute("sord");
    ArrayList<ingredients> ingrList= (ArrayList<ingredients>) request.getAttribute("ingrList");
    
%>

<html>	
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
			<ol class="breadcrumb">
		   	    <li><a href="/Six_Eagles/home">Home</a></li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Order Details of Supply Order: <%=sord.get(0).getSupplyOrderNum() %>
				</div>
				<div class="panel-body">
					<div class="panel-body">
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
	                            <th><center>Product Name</center></th>
	                            <th><center>Quantity Ordered</center></th>
	                            <!--<th><center>Comments</center></th>-->
							</tr>
                            	<% for(int i = 0; i < sord.size(); i++) { 
                              		supplyorderdetails sd = sord.get(i);
                              		ingredients ingr = ingrList.get(i);					%>
                               		<tr>
                            			<td><center><%=ingr.getIngredientName()%></center></td>
                            			<td><center><%=sd.getQuantity()%></center></td>
                      				</tr>
                                 <% } %>
						</thead>
						<tbody>
						
						</tbody>
					</table>
				</div>
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
