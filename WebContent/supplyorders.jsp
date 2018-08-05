<%-- 
    Document   : supplyorders
    Created on : 02 20, 18, 2:32:23 AM
    Author     : Joshua Sultan
--%>
<%@page import="dao.Supplierdao"%>
<%@page import="model.suppliers"%>
<%@page import="model.supplyorders"%>
<%@page import="dao.supplyordersdao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    ArrayList<supplyorders>sord = (ArrayList<supplyorders>) request.getAttribute("supplyOrders");
    ArrayList<suppliers>sup = (ArrayList<suppliers>) request.getAttribute("suppliersList");
    
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
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="/Six_Eagles/home">Home</a></li>		
		    <li><a href = "/Six_Eagles/manageOrders">Client Orders</a></li>
            <li><a href = "/Six_Eagles/viewArchivedClientOrders">Archived Client Orders</a></li>
			<li><a class = "active">Supplier Orders</a></li>
            <li><a href = "/Six_Eagles/viewArchivedSupplyOrders">Archived Supply Orders</a></li>
		</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Orders
				</div>
				<div class="panel-body">
                 	<div class="div-action pull pull-right" style="padding-bottom:20px;">
                         <button class="btn btn-default button1" data-toggle="modal" data-target="#changestatus"> <i class="glyphicon glyphicon-plus-sign"></i> Change Status</button>
                    </div> <!-- /div-action -->
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
		
<div class="modal fade" id="changestatus" tabindex="-1" role="dialog">
	<div class="modal-dialog">
	  <div class="modal-content">
	
	      <form class="form-horizontal" id="submitProductForm" action="changesupplyorderstatus" method="POST">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	              <h4 class="modal-title"><i class="fa fa-plus"></i> Add Supply Order</h4>
	            </div>
	               <div class="form-group">
	                      <label for="productPrice" class="col-sm-3 control-label">Supply order number </label>
	                      <label class="col-sm-1 control-label">: </label>
	                                  <div class="col-sm-8">
	                                    <select class="form-control" id="pono"  name="pono" autocomplete="off" style = "width : 300px" required>
	                                        <% for(supplyorders s : sord) { %>
	                                          <option value="<%=s.getSupplyOrderNum()%>"> <%=s.getSupplyOrderNum()%></option>
	                                        <% } %>
	                                    </select>
	                                  </div>
	              </div>
	                                    <div class="form-group">
	                      <label for="productPrice" class="col-sm-3 control-label">Status </label>
	                      <label class="col-sm-1 control-label">: </label>
	                                  <div class="col-sm-8">
	                                    <select class="form-control" id="status"  name="status" autocomplete="off" style = "width : 300px" required>
	                 
	                                          <option value="Processing">Processing</option>
	                                          <option value="Late">Late</option>
	                                          <option value="Delivered">Delivered</option>
	                                        
	                                        
	                                    </select>
	                                  </div>
	              </div>
	                                          <div class="modal-footer">
	              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	
	              <button type="submit" name = "submit" class="btn btn-success" id="createBrandBtn" data-loading-text="Loading..." autocomplete="off">Save Changes</button>
	            </div>
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
