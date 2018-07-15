<%-- 
    Document   : reports
    Created on : 02 20, 18, 2:30:39 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <jsp:include page="header.jsp"/>
		<div class="area container-fluid">
			<div class="panel panel-default">
				<div class="panel-heading">
					Reports
					<a href="newreport.jsp" style="position: absolute; right: 300px;">[New Report]</a>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Date</th>
								<th>Report Name</th>
								<th>Report Type</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><a data-toggle="modal" data-target="#deldetails">03-25-2017</a></td>
								<td><a data-toggle="modal" data-target="#deldetails">Delivery Summary</a></td>
								<td><a data-toggle="modal" data-target="#deldetails">Orders</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#invdetails">03-25-2017</td>
								<td><a data-toggle="modal" data-target="#invdetails">Daily Inventory Summary</td>
								<td><a data-toggle="modal" data-target="#invdetails">Inventory</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#invdetails">03-24-2017</td>
								<td><a data-toggle="modal" data-target="#invdetails">Weekly Inventory Summary</td>
								<td><a data-toggle="modal" data-target="#invdetails">Inventory</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#deldetails">03-24-2017</td>
								<td><a data-toggle="modal" data-target="#deldetails">Delivery Summary</td>
								<td><a data-toggle="modal" data-target="#deldetails">Orders</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#invdetails">03-24-2017</td>
								<td><a data-toggle="modal" data-target="#invdetails">Daily Inventory Summary</td>
								<td><a data-toggle="modal" data-target="#invdetails">Inventory</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#invdetails">03-22-2017</td>
								<td><a data-toggle="modal" data-target="#invdetails">Daily Inventory Summary</td>
								<td><a data-toggle="modal" data-target="#invdetails">Inventory</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#deldetails">03-21-2017</td>
								<td><a data-toggle="modal" data-target="#deldetails">Delivery Summary</td>
								<td><a data-toggle="modal" data-target="#deldetails">Orders</td>
							</tr>
							<tr>
								<td><a data-toggle="modal" data-target="#invdetails">03-21-2017</td>
								<td><a data-toggle="modal" data-target="#invdetails">Daily Inventory Summary</td>
								<td><a data-toggle="modal" data-target="#invdetails">Inventory</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div id="deldetails" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<img src="C:\Users\Ela P\Desktop\website\dr.jpg" class="img-responsive">
					</div>
				</div>
			</div>
		</div>
		
		<div id="invdetails" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<img src="C:\Users\Ela P\Desktop\website\ir.jpg" class="img-responsive">
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
			padding-left: 90px;
			background-color: #1E88E5;
			height: 100%;
			width: 100%;
			padding-right: 90px;
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