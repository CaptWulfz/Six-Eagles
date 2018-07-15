<%-- 
    Document   : supplier
    Created on : 02 20, 18, 2:31:34 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.Supplierdao" %>
<%@page import = "model.suppliers" %>

<!DOCTYPE html>
<%
    ArrayList<suppliers>sup= (ArrayList<suppliers>) request.getAttribute("suppliersList");
    
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
		  <li><a class = "active">Create Supplier</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Suppliers</b></div>
			</div> <!-- /panel-heading -->
			<div class = "messages">
					
					</div>
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addSupplierModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Supplier</button>
				</div> <!-- /div-action -->				
				
				<table class="table" id="manageSupplierTable">
					<thead>
						<tr>
							<th>Supplier Name</th>
							<th>Address</th>
                                                        <th>City</th>
                                                        <th>Contact</th>
						</tr>
                                                <%
                                                    for(suppliers s:sup){
                                                %>
                                                <tr>
                                                    <td><center><%=s.getSupplierName()%></center></td>
                                                    <td><center><%=s.getAddress()%></center></td>
                                                    <td><center><%=s.getCity()%></center></td>
                                                    <td><center><%=s.getContact()%></center></td>
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
		
		

		
<div class="modal fade" id="addSupplierModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitProductForm" action="addsupplier" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Add Supplier</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Supplier Name: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="supplierName" placeholder="Supplier Name" name="supplierName" autocomplete="off" required>
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
	        	<label for="productPrice" class="col-sm-3 control-label">City: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="city" placeholder="City" name="city" autocomplete="off" required>
				    </div>
	        </div>
                <div class="form-group">
	        	<label for="productPrice" class="col-sm-3 control-label">Contact: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="contact" placeholder="contact number or e-mail" name="contact" autocomplete="off" required>
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


