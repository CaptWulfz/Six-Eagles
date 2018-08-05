<%-- 
    Document   : orders
    Created on : 02 20, 18, 2:27:43 AM
    Author     : Joshua Sultan
--%>

<%@page import = "dao.ClientOrderdao" %>
<%@page import= "model.Orders" %>
<%@page import = "model.Client" %>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 

ArrayList<Orders>order = (ArrayList<Orders>) request.getAttribute("ordersList");
ArrayList<Client> clientList = (ArrayList<Client>) request.getAttribute("clientList");

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
			    <li><a class = "active">Client</a></li>
				<li><a href = "/Six_Eagles/viewArchivedClientOrders">Archived Client Orders</a></li>
				<li><a href = "/Six_Eagles/viewSupplyOrders">Supplier</a></li>
				<li><a href = "/Six_Eagles/viewArchivedSupplyOrders">Archived Supply Orders</a></li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-heading">
					Orders
				</div>
				<div class="panel-body">
                                    <div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addIngredientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Change Status</button>
				</div> <!-- /div-action -->
					<table class="table table-hover" align = "center">
						<thead>
							<tr>
                                                            <th><center>Purchase Order No.</center></th>
                                                            <th><center>Client</center></th>
                                                            <th><center>Delivery Receipt No.</center></th>
                                                            <th><center>Order Date</center></th>
                                                            <th><center>Delivery Date</center></th>
                                                            <th><center>Status</center></th>
                                                            <!--<th><center>Comments</center></th>-->
							</tr>
                                                        
                                              <% for(int i = 0; i < order.size(); i++) {
                                             	 	Orders o = order.get(i);
                                            	  	Client c = clientList.get(i); %>
                                                         
                                                 <tr>
                                                    <td><center><%=o.getPurchaseOrderNum()%></center></td>
                                                    <td><center><%=c.getClientName() %></center>
                                                    <td><center><%=o.getDeliveryrecieptNum()%></center></td>
                                                    <td><center><%=o.getOrderdate()%></center></td>
                                                    <td><center><%=o.getDeliverydate()%></center></td>
                                                    <td><center><%=o.getStatusDetails()%></center></td>
                                        			<td>
                                        			<form method = "post" action = "/Six_Eagles/vieworderdetails">
                                        				<center><button type = "submit" name = "submitBtn" value = "<%=o.getPurchaseOrderNum() %>" class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View Order Details</button></center><td>
                                                	</form>
                                                </tr>
                                                <%}%>
						</thead>
						<tbody>
						
						</tbody>
					</table>
                                </div>
                        </div>
                       </div> 
                                                
<div class="modal fade" id="addIngredientModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitIngredientForm" action="changeorderstatus" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Add Ingredient</h4>
	      </div>
	      <div class="modal-body">
	      	<div class="form-group">
	        	<label class="control-label col-sm-3" for="col2">Product</label>
	         	<label class="col-sm-1 control-label">: </label>
	            <div class="col-sm-8">
	
	           		<select class="form-control" id="pono" name="pono" style = "width : 300px" required>
                    	<% for(Orders o : order) { %>
	                    	<option value="<%=o.getPurchaseOrderNum()%>"> <%=o.getPurchaseOrderNum()%> </option>
						<% } %>
	                </select>
	            </div>
	     	</div>
	     	
          	<div class="form-group">
	         <label class="control-label col-sm-3" for="col2">Product</label>
	         <label class="col-sm-1 control-label">: </label>
	             <div class="col-sm-8">
	
	                 <select class="form-control" id="status" name="status" style = "width : 300px" required>
	                     <option value="Late"> Late </option>
	                     <option value="Processing"> Processing </option>
	                     <option value="Delivered"> Delivered </option>
	                     
	                 </select>
	             </div>
	     </div>
	     
	     </div> <!-- /modal-body -->
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        
	        <button type="submit" class="btn btn-success" name="submit" id="createBrandBtn" data-loading-text="Loading..." autocomplete="off">Save Changes</button>
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
