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
    ArrayList<ingredients>ingr = (ArrayList<ingredients>) request.getAttribute("ingrList");
    
%>
<html>
<jsp:include page="header.jsp"/>
<body>
	<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
			<li><a href="/Six_Eagles/home">Home</a></li>
			<li><a href="/Six_Eagles/ingredients">Add Ingredients</a></li>
			<li><a class = "active">Reactivate Ingredient</a></li>
<!--		  <li class="active">Brand</li>   -->
		</ol>
	
		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"> <b>Ingredients</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<!--<button class="btn btn-default button1" data-toggle="modal" data-target="#addIngredientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Ingredient</button>-->
				</div> <!-- /div-action -->				
				
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
                                                    <td><center><%=i.getStock()%></center></td>
                                                    <td><center><%=i.getThreshold()%></center></td>
                                                    <td><center><%=i.getCeiling()%></center></td>
                                                    <td><center><%=i.getUnitOfMeasurement()%></center></td>
                                                    <td>
                                                    	<form method = "post" action = "/Six_Eagles/reactivateingredient">
                                                    		<center><button type = "submit" name = "submitBtn" value = <%=i.getIngredientCode() %> class="btn btn-default button1"> <i class="glyphicon glyphicon-plus-sign"></i> Reactivate</button></center>
                                                		</form>
                                                	</td>
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
     	
	     <!-- /.form -->
    </div>
    <!-- /modal-content -->
  
  <!-- /modal-dailog -->

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