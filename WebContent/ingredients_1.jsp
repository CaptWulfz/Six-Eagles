<%-- 
    Document   : ingredients
    Created on : 02 20, 18, 3:46:25 AM
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
    
    String name = productdao.viewproductname();
    int code = productdao.viewproduct();
    ArrayList<ingredients>ing=ingredientsdao.viewIngredientactive();
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
<body>
	<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
			<!--<li><a href="home.jsp">Home</a></li>
			<li><a class = "active">Add Ingredients</a></li>
			<li><a href="ReactivateIngredients.jsp">Reactivate Ingredient</a></li>
<!--		  <li class="active">Brand</li>   -->
		</ol>
	
		
			<div class="panel panel-default" style="width: 100%; margin-left: 0%;">
				<div class="panel-heading">
                                Add Ingredient to product
				</div>
				<div class="messages">
						
				<div class="panel-body">
					<form class="form-horizontal" action="addIngredientlists" method="post">
						<div class="form-group">
							<label class="control-label col-sm-3" for="col2">Product</label>
                                                        <label class="col-sm-1 control-label">: </label>
							<div class="col-sm-8">
                                                            <input class="lorem form-control"  name="productadd" id="productadd" placeholder="<%=name%>" style="width: 300px;" disabled>
                                                             <input type="hidden" class="form-control" id="productName" placeholder="Product Name" name="productAdds" value="<%=code%>" autocomplete="off" >
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
                                                                            <label for="productPrice" class="col-sm-3 control-label">Amount</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="amountadd" placeholder="Amount" name="amountadd" autocomplete="off">
                                                                                        </div>
                                                                    </div>
                                                                                    <div class="form-group">
                                                                            <label for="productPrice" class="col-sm-3 control-label">Unit</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="unitadd" placeholder="Uint" name="unitadd" autocomplete="off">
                                                                                        </div>
                                                                    </div>
						<button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Add ingredient</button></a>
                                                
					</form>
                                         <a href="inventory.jsp"><button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Finish</button></a>                                           
				</div>
			</div>
		</div>
                </div>

			</div> <!-- /panel-body -->
				
	</div> <!-- /col-md-12 -->



<div class="modal fade" id="addIngredientModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitIngredientForm" action="addIngredient" method="POST">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><i class="fa fa-plus"></i> Add Ingredient</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label for="productName" class="col-sm-3 control-label">Ingredient Name </label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="ingredientName" placeholder="Ingredient Name" name="ingredientName" autocomplete="off">
				    </div>
	        </div> <!-- /form-group-->	
			 <div class="form-group">
	        	<label for="availableStock" class="col-sm-3 control-label">Stock</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" min="0" class="form-control" id="availableStock" placeholder="Available Stock" name="availableStock" autocomplete="off">
				    </div>
	        </div>
			  <div class="form-group">
	        	<label for="threshold" class="col-sm-3 control-label">Threshold</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" min="0" class="form-control" id="threshold" placeholder="Threshold" name="threshold" autocomplete="off">
				    </div>
	        </div>
			<div class="form-group">
	        	<label for="ceiling" class="col-sm-3 control-label">Ceiling</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" min="0" class="form-control" id="Ceiling" placeholder="Ceiling" name="ceiling" autocomplete="off">
				    </div>
	        </div>
			<div class="form-group">
	        	<label for="unitOfMeasurement" class="col-sm-3 control-label">Unit of Measurement</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="unitOfMeasurement" placeholder="Unit of Measurement" name="unitOfMeasurement" autocomplete="off">
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
			width: 110%;
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