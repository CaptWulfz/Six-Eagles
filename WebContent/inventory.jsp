<%-- 
    Document   : inventory
    Created on : 02 20, 18, 1:22:15 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.productdao" %>
<%@page import= "model.product" %>
<%@page import = "dao.ingredientsdao" %>
<%@page import= "model.ingredients" %>
<!DOCTYPE html>

<%
    
    ArrayList<product>prod = (ArrayList<product>) request.getAttribute("prodList");
    ArrayList<ingredients>ing= (ArrayList<ingredients>) request.getAttribute("ingList");
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
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="home.jsp">Home</a></li>		
		  <li><a class = "active">Add Product</a></li>
		  <li><a href="physicalcount.jsp">Physical Count</a></li>
		  <li><a href="reactivateinventory.jsp">Reactivate Product</a></li>
		  <li><a href="updateprodad.jsp">Update Inventory</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Products</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addProductModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Product</button>
                    <button class="btn btn-default button1" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-plus-sign"></i>Add Ingredient</button>
                    <button class="btn btn-default button1" data-toggle="modal" data-target="#changeCodeModal"> <i class="glyphicon glyphicon-plus-sign"></i> Change Product Codes</button>
                    <button class="btn btn-default button1" data-toggle="modal" data-target="#changeThresholdsModal"> <i class="glyphicon glyphicon-plus-sign"></i> Change Thresholds</button>
                                        
                                                    <div class="modal fade" id="myModal" role="dialog">
                                                        <div class="modal-dialog">

                                                          <!-- Modal content-->
                                                          <div class="modal-content">
                                                              <form class="form-horizontal" id="submitRawMaterialsForm" action="addIngredientlistsmodal" method="POST">
                                                            <div class="modal-header">
                                                              <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                              <h4 class="modal-title">Modal Header</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Product</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="productadd" name="productadds" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(product p : prod){   
                                                                                                    %>
                                                                                        <option value="<%=p.getProductcode()%>"> <%=p.getProductname()%> </option>
                                                                                        
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
                                                                <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Ingredient</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="ingredientadd" name="ingredientadd" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(ingredients I : ing){   
                                                                                                    %>
                                                                                        <option value="<%=I.getIngredientCode()%>"> <%=I.getIngredientName()%> </option>
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
                                                              <div class="form-group">
                                                                            <label for="productPrice" class="col-sm-3 control-label">Quantity</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="amountadd" placeholder="Quantity" name="amountadd" autocomplete="off">
                                                                                        </div>
                                                                    </div>
                                                                                    <div class="form-group">
                                                                            <label for="productPrice" class="col-sm-3 control-label">Unit</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="unitadd" placeholder="Unit" name="unitadd" autocomplete="off">
                                                                                        </div>
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
				</div> <!-- /div-action -->				
				
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
                                                    <th><center>Name</center></th>
                                                    <th><center>Price</center></th>
                                                    <th><center>Stocks (in Pcs.)</center></th>
                                                    <th><center>Threshold</center></th>
                                                    <th><center>Ceiling</center></th>
                                                    <th><center>Status</center></th>
						</tr>
                                                
                                                <%
                                                    
                                                    for(product p : prod){
                                                        
                                                %>
                                                
                               <tr>
                                   <td><center><%=p.getProductname()%></center></td>
                                   <td><center><%=p.getProductprice()%></center></td>
                                   <td><center><%=p.getStock()%></center></td>
                                   <td><center><%=p.getThreshold()%></center></td>
                                   <td><center><%=p.getCeiling()%></center></td>
                                	<td>
	                                	<form method = "post" action = "/Six_Eagles/deactivateproduct">
	                                		<center><button type = "submit" name = "submitButton" value = <%=p.getProductcode()%> class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>Phase Out</button></center>
	                                	</form>
                               		</td>	
                                               
                                	<td><center><a href="viewIngredientslist?code=<%=p.getProductcode()%>"><button class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View ingredients</button></a></center></td>
                                	
                                </tr>
                                                <% } %>
					</thead>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
		

<div class="modal fade" id="viewIngredients" tabindex="-1" role="dialog">
  <div class="modal-dialog">
      <div class="modal-content">
      
          <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Product</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="productadd" name="productadd" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(product p : prod){   
                                                                                                    %>
                                                                                        <option value="<%=p.getProductcode()%>"> <%=p.getProductname()%> </option>
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
          
          <table class="table" id="manageProductTable">
					<thead>
						<tr>
                                                    <th><center>Name</center></th>
                                                    <th><center>Price</center></th>
                                                    <th><center>Stocks (in Pcs.)</center></th>
                                                    <th><center>Threshold</center></th>
                                                    <th><center>Ceiling</center></th>
                                                    <th><center>Status</center></th>
						</tr>
                                                
                                                <%
                                                    
                                                    for(product p : prod){
                                                        
                                                %>
                                                
                                                <tr>
                                                    <td><center><%=p.getProductname()%></center></td>
                                                    <td><center><%=p.getProductprice()%></center></td>
                                                    <td><center><%=p.getStock()%></center></td>
                                                    <td><center><%=p.getThreshold()%></center></td>
                                                    <td><center><%=p.getCeiling()%></center></td>
                                                    
                                                </tr>
                                                <% } %>
					</thead>
				</table>
          
          
      </div> 
    </div>
</div>

<div class="modal fade" id="changeCodeModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitProductForm" action="/Six_Eagles/changeProductCode" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Change Product Codes</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Product Name: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				     	<select class="form-control" id="city" name="productName" style = "width : 300px">
				     		<% for (product p : prod) { %>
				     			<option value = <%=p.getProductcode() %>><%= p.getProductname()%></option>
				     		<% } %>
						</select>
				    </div>
	        </div> <!-- /form-group-->	
			 <div class="form-group">
	        	<label for="productCode" class="col-sm-3 control-label">Product Code: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="productCode" placeholder="Code" name="productCode" autocomplete="off" required>
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

<div class="modal fade" id="changeThresholdsModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitProductForm" action="/Six_Eagles/changeThresholds" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Change Product Codes</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Product Name: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				     	<select class="form-control" id="city" name="productName" style = "width : 300px">
				     		<% for (product p : prod) { %>
				     			<option value = <%=p.getProductcode() %>><%= p.getProductname()%></option>
				     		<% } %>
						</select>
				    </div>
	        </div> <!-- /form-group-->	
			 <div class="form-group">
	        	<label for="productThreshold" class="col-sm-3 control-label">Threshold: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="productThreshold" placeholder= 0 name="threshold" autocomplete="off" required>
				    </div>
	        </div>    	    
	        
	        	 <div class="form-group">
	        	<label for="productCeiling" class="col-sm-3 control-label">Ceiling: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="productCeiling" placeholder= 0 name="ceiling" autocomplete="off" required>
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

		
<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitProductForm" action="addProduct" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Add Product</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Product Name: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName" autocomplete="off" required>
				    </div>
	        </div> <!-- /form-group-->	
			 <div class="form-group">
	        	<label for="productPrice" class="col-sm-3 control-label">Product Price: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="productPrice" placeholder="Price" name="productPrice" autocomplete="off" required>
				    </div>
	        </div>
			 <div class="form-group">
	        	<label for="availableStock" class="col-sm-3 control-label">Stocks Available: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="availableStock" placeholder="Available Stock" value = 0 name="availableStock" autocomplete="off" required>
				    </div>
	        </div>

			 <div class="form-group">
	        	<label for="threshold" class="col-sm-3 control-label">Threshold: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="threshold" placeholder="Threshold" name="threshold" value = 0 autocomplete="off">
				    </div>
	        </div>
			 <div class="form-group">
	        	<label for="ceiling" class="col-sm-3 control-label">Ceiling: </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" class="form-control" id="ceiling" placeholder="Ceiling" name="ceiling" value = 0 autocomplete="off">
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