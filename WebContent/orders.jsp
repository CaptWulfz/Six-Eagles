<%-- 
    Document   : orders
    Created on : 02 20, 18, 2:27:43 AM
    Author     : Joshua Sultan
--%>

<%@page import = "dao.ClientOrderdao" %>
<%@page import= "model.Orders" %>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 

ArrayList<Orders>order = ClientOrderdao.viewClientOrder();

%>
<html>	
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
		<ol class="breadcrumb">
	   	    <li><a href="home.jsp">Home</a></li>		
		    <li><a class = "active">Client</a></li>
			<li><a href = "ArchivedClientOrders.jsp">Archived Client Orders</a></li>
			<li><a href = "supplyorders.jsp">Supplier</a></li>
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
                                                            <th><center>Delivery Receipt No.</center></th>
                                                            <th><center>Order Date</center></th>
                                                            <th><center>Delivery Date</center></th>
                                                            <th><center>Status</center></th>
                                                            <!--<th><center>Comments</center></th>-->
							</tr>
                                                        
                                                        <%
                                                        for(Orders o : order){
                                                         %>
                                                         
                                                         <tr>
                                                    <td><center><%=o.getPurchaseOrderNum()%></center></td>
                                                    <td><center><%=o.getDeliveryrecieptNum()%></center></td>
                                                    <td><center><%=o.getOrderdate()%></center></td>
                                                    <td><center><%=o.getDeliverydate()%></center></td>
                                                    <td><center><%=o.getStatusDetails()%></center></td>
                                        <td><center><a href="vieworderdetails?code=<%=o.getPurchaseOrderNum()%>"><button class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View Order Details</button></a></center><td>
                                                </tr>
                                                <%}%>
						</thead>
						<tbody>
						
						</tbody>
					</table>
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

                                                                                    <select class="form-control" id="pono" name="pono" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(Orders o : order){   
                                                                                                    %>
                                                                                        <option value="<%=o.getPurchaseOrderNum()%>"> <%=o.getPurchaseOrderNum()%> </option>
                                                                                        
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
                                                                                    <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Product</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="status" name="status" style = "width : 300px">
                                                                                        <option value="Late"> Late </option>
                                                                                        <option value="Processing"> Processing </option>
                                                                                        <option value="Delivered"> Delivered </option>
                                                                                        
                                                                                    </select>
                                                                                </div>
                                                                        </div>
<!--			
	        <div class="form-group">
	        	<label for="brandStatus" class="col-sm-3 control-label">Status: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <select class="form-control" id="brandStatus" name="brandStatus">
				      	<option value="">~~SELECT~~</option>
				      	<option value="1">Available</option>
				      	<option value="2">Not Available</option>
				      </select>
				    </div>
	        </div> <!-- /form-group-->	         	        

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
