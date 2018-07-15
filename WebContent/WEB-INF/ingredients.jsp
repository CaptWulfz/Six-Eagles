<%-- 
    Document   : ingredients
    Created on : 02 20, 18, 1:19:40 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
			<li><a href="home.jsp">Home</a></li>
			<li><a class = "active">Add Ingredients</a></li>
			<li><a href="ReactivateIngredients.jsp">Reactivate Ingredient</a></li>
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
				
				<table class="table" id="manageIngredientTable">
					<thead>
						<tr>							
							<th>Ingredient Name</th>
							<th>Brand</th>
							<th>Packaging Amount</th>
							<th>Packaging</th>
							<th>Stock</th>
							<th>Threshold</th>
							<th>Ceiling</th>
							<th>Unit of Measurement</th>
							<th>Amount</th>
							<th>Status</th>
						</tr>
					</thead>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->


<div class="modal fade" id="addIngredientModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    	
    	<form class="form-horizontal" id="submitIngredientForm" action="" method="POST">
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
	        	<label for="productPrice" class="col-sm-3 control-label">Ingredient Brand</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="brand" placeholder="Brand" name="brand" autocomplete="off">
				    </div>
	        </div>
			 <div class="form-group">
	        	<label for="availableStock" class="col-sm-3 control-label">Packaging Amount</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="number" min="0" step="0.01" class="form-control" id="packagingAmount" placeholder="Packaging Amount" name="packagingAmount" autocomplete="off">
				    </div>	
			</div>
			<div class="form-group">
	        	<label for="availableStock" class="col-sm-3 control-label">Packaging</label>
	        	<label class="col-sm-1 control-label">: </label>
				    <div class="col-sm-8">
				      <input type="text" min="0" step="0.01" class="form-control" id="packaging" placeholder="Packaging" name="packaging" autocomplete="off">
				    </div>
	        </div>
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