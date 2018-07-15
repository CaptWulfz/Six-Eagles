<%-- 
    Document   : client
    Created on : 02 20, 18, 1:13:26 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.clientdao" %>
<%@page import = "model.Client" %>

<!DOCTYPE html>
<%
    ArrayList<Client>cl=clientdao.viewClientdeactive();
    
%>
<html>
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<script>
			$(document).ready(function(){
			$('[data-toggle="popover"]').popover(); 
			});
		</script>	
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="home.jsp">Home</a></li>		
		  <li><a href="client.jsp" >Create Client</a></li>
                  <li><a class = "active" >Reactivate Client</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Clients</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addClientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Client</button>
				</div> <!-- /div-action -->				
				
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
                                                    <th><center>Client Name</center></th>
                                                    <th><center>Address</center></th>
                                                    <th><center>City</center></th>
						</tr>
                                                                                                <%
                                                    for(Client c:cl){
                                                %>
                                                <tr>
                                                    <td><center><%=c.getClientID()%></center></td>
                                                    <td><center><%=c.getClientName()%></center></td>
                                                    <td><center><%=c.getAddress()%></center></td>
                                                    <td><center><%=c.getCity()%></center></td>
                                <td><center><a href="reactivateclient?code=<%=c.getClientID()%>"><button class="btn btn-default button1"> <i class="glyphicon glyphicon-plus-sign"></i> Reactivate</button></a></center></td>
                                                </tr>
                                                <%}%>
					</thead>
					<tbody>	
						
					</tbody>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
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