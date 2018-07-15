<%-- 
    Document   : ingredients
    Created on : 02 20, 18, 3:46:25 AM
    Author     : Joshua Sultan
--%>

<%@page import="dao.rawmaterialsdao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.rawmaterialsdao" %>
<%@page import= "model.rawmaterials" %>
<%@page import = "dao.Supplierdao" %>
<%@page import= "model.suppliers" %>
<!DOCTYPE html>

<%
    
    String name = Supplierdao.viewsuppliername();
    int code = Supplierdao.viewsupplierid();
    ArrayList<rawmaterials>raw=rawmaterialsdao.viewRaw();
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
                                Add Raw Materials to Supplier
				</div>
				<div class="messages">
						
				<div class="panel-body">
					<form class="form-horizontal" action="addRawmatssupplier" method="post">
						<div class="form-group">
							<label class="control-label col-sm-3" for="col2">Supplier</label>
                                                        <label class="col-sm-1 control-label">: </label>
							<div class="col-sm-8">
                                                            <input class="lorem form-control"  name="productadd" id="productadd" placeholder="<%=name%>" style="width: 300px;" disabled>
                                                             <input type="hidden" class="form-control" id="supplierid"  name="supplierid" value="<%=code%>" autocomplete="off" >
							</div>
						</div>
						<div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Ingredient</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="rawmatsadd" name="rawmatsadd" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(rawmaterials r : raw){   
                                                                                                    %>
                                                                                        <option value="<%=r.getRawMaterialCode()%>"> <%=r.getIngredientBrand()%> </option>
                                                                                        
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
						<button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Add ingredient</button></a>
                                                
					</form>
                                         <a href="supplier.jsp"><button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Finish</button></a>                                           
				</div>
			</div>
		</div>
                </div>

			</div> <!-- /panel-body -->
				
	</div> <!-- /col-md-12 -->


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