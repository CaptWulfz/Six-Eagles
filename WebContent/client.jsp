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
    ArrayList<Client> cl = (ArrayList<Client>) request.getAttribute("clientList");
	String sortedBy="";
    try{
        sortedBy=(String) request.getAttribute("SortedBy");
    } catch(Exception e){        
    }
%>
<html>
    <jsp:include page="header.jsp"/>
    <head>
		<title>Eagle's Eye</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
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
		  <li><a class = "active">Create Client</a></li>
                  <li><a href="reactivateclient.jsp">Reactivate Client</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Clients</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addClientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Client</button>
				</div> <!-- /div-action -->				
				
                                <div class="col-sm-8">
                                    <% if(sortedBy != null){%>
                                    <h1><%=sortedBy%>
                                    </h1>
                                    <%}%>
                                    <form action="clientSort" method="POST" name="drop">
                                    <select id="fDown" name="fDown">
                                            <option Value=1>Default</option>
                                            <option Value=2>View By Asc:Name</option>
                                            <option Value=3>View By Desc:Name</option>
                                            <option Value=4>View By Asc:City</option>
                                            <option Value=5>View By Desc:City</option>
                                        </select>
                                        <button id="filter" type="submit" name="send">Filter</button>
                                    </form>
                                    </div>
                                
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
                                                    <th><center>Client Name</center></th>
                                                    <th><center>Address</center></th>
                                                    <th><center>City</center></th>
						</tr>
                                              <%
                                                    if(cl != null){
                                                    for(Client c:cl){
                                                %>
                                                <tr>
                                                    <td><center><%=c.getClientName()%></center></td>
                                                    <td><center><%=c.getAddress()%></center></td>
                                                    <td><center><%=c.getCity()%></center></td>
                                <td><center><a href="deactivateclient?code=<%=c.getClientID()%>"><button class="btn btn-default button1"> <i class="glyphicon glyphicon-plus-sign"></i> Deactivate</button></a></center></td>
                                              
                                                </tr>
                                                <%}
}
                                                %>
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
		
		

		
    <div class="modal fade" id="addClientModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitProductForm" action="addClient" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Add Client</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Client Name: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="clientName" placeholder="Client Name" name="clientName" autocomplete="off" required>
				    </div>
	        </div> <!-- /form-group-->	
			 <div class="form-group">
	        	<label for="productPrice" class="col-sm-3 control-label">Address: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="address" placeholder="Address" name="address" autocomplete="off" required>
				    </div>
	        </div>
                    <div class="form-group">
			<label class="control-label col-sm-3" for="col2">City</label>
                            <div class="col-sm-8">
                                <label class="col-sm-1 control-label">: </label>
                                <div class="col-sm-8">
				<select class="form-control" id="city" name="city" style = "width : 300px">
                                            <option value="Caloocan">Caloocan</option>
                                            <option value="LasPiñas">Las Piñas</option>
                                            <option value="Makati">Makati</option>
                                            <option value="Malabon">Malabon</option>
                                            <option value="Mandaluyong">Mandaluyong</option>
                                            <option value="Manila">Manila</option>
                                            <option value="Marikina">Marikina</option>
                                            <option value="Muntinlupa">Muntinlupa</option>
                                            <option value="Navotas">Navotas</option>
                                            <option value="Parañaque">Parañaque</option>
                                            <option value="Pasay">Pasay</option>
                                            <option value="Pasig">Pasig</option>
                                            <option value="Quezon">Quezon</option>
                                            <option value="SanJuan">SanJuan</option>
                                            <option value="Taguig">Taguig</option>
                                            <option value="Valenzuela">Valenzuela</option> 
				</select>
                                </div>
                            </div>
                    </div>                
	      </div> <!-- /modal-body -->
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        
	        <button type="submit" name = "submit" class="btn btn-success" id="createBrandBtn" data-loading-text="Loading..." autocomplete="off">Save Changes</button>
	      </div>
	      <!-- /modal-footer -->
     	</form>
	     <!-- /.form -->
    </div>
    <!-- /modal-content -->
  </div>
  <!-- /modal-dailog -->
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