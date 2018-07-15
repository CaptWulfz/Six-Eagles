<%-- 
    Document   : updateproduct
    Created on : 02 20, 18, 2:34:34 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <jsp:include page="header.jsp"/>
<header>
</header>
<body>
	<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="home.jsp">Home</a></li>		
		  <li><a href = "inventory.jsp">Add Product</a></li>
		  <li><a href="physicalcount.jsp">Physical Count</a></li>	
		  <li><a class="active">Make Product</a></li>


		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"> Add Manufactured Product</div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
			<!--	<div class="div-action pull pull-right" style="padding-bottom:20px;">
					<button class="btn btn-default button1" data-toggle="modal" data-target="#addIngredientModal"> <i class="glyphicon glyphicon-plus-sign"></i> Add Product</button>
				</div> <!-- /div-action -->				
				<form method="post" action="">
				<div class="select-wrapper">
						<select name="Prodname" id="Prodname" required>
							<option value='' selected disabled>- Products -</option>
							
							
							<!--<option value='SR-001'>Standard Room </option>
							<option value='TR-002'>Twin Room</option>
							<option value='DR-003'>Delux Room</option>
							<option value='PS-004'>Premium Suite</option>-->
							

						</select>
						
					<input type="number" name="makeqty" id="makeqty" value="" placeholder="Quantity" required />
			
					<button  type="submit" name="submit" value="submit" class="btn btn-primary">Make Product</button>	
				</div>
			
				</form>
				
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->



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
