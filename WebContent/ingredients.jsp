<%-- 
    Document   : ingredients
    Created on : 02 20, 18, 3:46:25 AM
    Author     : Joshua Sultan
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dao.ingredientsdao" %>
<%@page import = "model.ingredients" %>

<!DOCTYPE html>
<%
    ArrayList<ingredients>ingr= (ArrayList<ingredients>) request.getAttribute("ingredientsList");  
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
			<li><a href="/Six_Eagles/home">Home</a></li>
			<li><a class = "active">Add Ingredients</a></li>
			<li><a href="reactivateingredients.jsp">Reactivate Ingredient</a></li>
<!--		  <li class="active">Brand</li>   -->
		</ol>
	
		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"> <b>Ingredients</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addIngredientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Ingredient</button>
				</div> <!-- /div-action -->				
				
				<div>
					<form method = "post" action = "ingredients">
					Search: <input class = "search-bar" type = "text" name = "ingredient-name">
					</form>
				</div>
				
				<table class="table" id="manageIngredientTable">
					<thead>
						<tr>							
							<th><center>Ingredient Name</center></th>
                                                        <th><center>Unit</center></th>
                                                        <th><center>Stock</center></th>
							<th><center>Threshold</center></th>
                                                        <th><center>Ceiling</center></th>
							<th><center>Status</center></th>
						</tr>
                                                
                                                
                                                <%
                                                    for(ingredients i : ingr){
                                                        
                                                                                                                                                                                
                                                    
                                                %>
                                                <tr>
                                                    <td><center><%=i.getIngredientName()%></center></td>
                                                    <td><center><%=i.getUnitOfMeasurement()%></center></td>
                                                    <td><center><%=i.getStock()%></center></td>
                                                    <td><center><%=i.getThreshold()%></center></td>
                                                    <td><center><%=i.getCeiling()%></center></td>
                                                    
                                                    <td><center><a href="deactivateingredient?code=<%=i.getIngredientCode()%>"><button class="btn btn-default button1"> <i class="glyphicon glyphicon-plus-sign"></i> Deactivate</button></a></center></td>
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
				<label for="unitOfMeasurement" class="col-sm-3 control-label" id = "tooltip">Unit of Measurement <img src = "images/tooltip-icon.png" height = "10" width = "10">
	        		<span class = "tooltiptext">
	        		E.g:<br>
	        		Liquid Items : Liters <br>
	        		Solid Items : Kg <br>
	        		Eggs : by Dozens<br>
	        		Cubed Items (Knorr Cubes) : Per Cube<br>
	        		</span>
	        	</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				    	
				    		<select class = "form-control" id = "unitOfMeasurement" name = "unitOfMeasurement">
					    		<option value = "Kg">Kg</option>
					    		<option value = "Grams">Liters</option>
					    		<option value = "Dozen">Dozen</option>
				    			<option value = "Per Cube">Per Cube</option>
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
		
		#tooltip {
		    position: relative;
		    display: inline-block;
		    border-bottom: 1px dotted black;
		}
		
		#tooltip .tooltiptext {
			visibility: hidden;
			width: 300px;
		    background-color: black;
		    color: #fff;
		    text-align: justify;
		    padding-left: 10px;
		    padding: 5px;
		    border-radius: 6px;	
		    
		    position: absolute;
		    z-index: 1;
		    top: 100%;
		    left: 50%;
		    margin-left: -60px;
		}
		
		#tooltip:hover .tooltiptext {
			visibility: visible;
		}
		
		#tooltip .tooltiptext::after {
		    content: " ";
		    position: absolute;
		    bottom: 100%;  /* At the top of the tooltip */
		    left: 50%;
		    margin-left: -5px;
		    border-width: 5px;
		    border-style: solid;
		    border-color: transparent transparent black transparent;
		}
	</style>