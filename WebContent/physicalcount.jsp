<%-- 
    Document   : physicalcount
    Created on : 02 20, 18, 2:28:17 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
			<ol class="breadcrumb">
			  <li><a href="home.php">Home</a></li>		
			  <li><a href = "inventory.jsp">Add Product</a></li>
			  <li><a class = "active">Physical Count</a></li>
			  <li><a href="reactivateinventory.jsp">Reactivate Product</a></li>
                       <li><a href = "updateprodad.jsp">Update Product</a></li>
			</ol>
			<div class="panel panel-default" style="width: 100%; margin-left: 0%;">
		
				<div class="panel-heading">
					<b>Input Physical Count</b>
				</div>
				<div class = "messages">
					
					</div>
				<div class="panel-body">
					<form class="form-horizontal" action="" method = "POST">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Product:</label>
							<div class="col-sm-7">
								<select class="form-control" id="productName" name="productName" style = "width : 300px">
									<option value = ""></option>
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Physical Count:</label>
							<div class="col-sm-7">
								<input type="number" class="lorem form-control" name = "physicalCount" id="col1" style="width: 300px;">
							</div>
						</div>
						
						<button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-check"></i> Check Count</button></a>
					</form>
				</div>
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
			padding-left: 200px;
			padding-right: 200px;
			background-color: #1E88E5;
			height: 100%;
		}
		
		.panel-body {
			width: 100%;
			margin-left: 0px;
		}
		
		.form-horizontal .lorem, .ipsum, .dolor, .sit, .amet {
			margin-left: 0px;
			width: 75%;
		}
		
		.btn {
			margin-top: 15px;
			margin-right: 5px;
		}
	</style>
</html>