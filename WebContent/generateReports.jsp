<%-- 
    Document   : generateReports
    Created on : 04 12, 18, 12:06:19 PM
    Author     : AJ's Laptop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Report</title>
    </head>
    <jsp:include page="header.jsp"/>
    <script src="jquery-3.3.1.min.js"></script>
    <script>
			$(document).ready(function(){
			$('[data-toggle="popover"]').popover(); 
			}); 
	</script>	
    <body da ta-spy="scroll" data-target=".navbar" data-offset="50">
		<div class="area container-fluid">
			<ol class="breadcrumb">
			  <li><a href="home.jsp">Home</a></li>		
			  <li><a class = "active">Sales Report</a></li>
			</ol>
			<div id = "generateReports" class = "panel panel-default" style = "width: 100%; margin-left: 0%">
				<div class = "panel-heading">
					Generate Reports
				</div>
				<div class = "messages">
					<div class = "panel-body">
						<form class="form-horizontal" action="ReportsServ" method="POST" name="viewReport">
					    	<div class = "form-group">
					    		<label class = "control-label col-sm-5" for = "col1">Report Coverage From:</label>
					    		<div class="col-sm-7">
									<input type="date" class="sit form-control" id="ddate" name="start" placeholder="yyyy-mm-dd" value = <%=request.getAttribute("dateToday") %> style="margin-bottom: 5px; width: 150px;" required>
								</div>
					    	</div>
					    	<div class = "form-group">
					    		<label class = "control-label col-sm-5" for = "col1">To:</label>
					    		<div class="col-sm-7">
									<input type="date" class="sit form-control" id="ddate" name="end" placeholder="yyyy-mm-dd" value = <%=request.getAttribute("dateToday") %> style="margin-bottom: 5px; width: 150px;" required>
								</div>
					    	</div>
					    	<div class = "form-group">
					    		<label class = "control-label col-sm-5" for = "col1">Type of Report:</label>
					    		<div class = "col-sm-7">
					    			 <select class="form-control" id="drop" name="drop" style = "width : 150px">
					               	 	<option Value=1>Sales Report</option>
					               	 	<option Value=2>Inventory Report</option>
					            	</select>
					    		</div>
					    	</div>
					    	<button type="submit" name = "submitBtn" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button>
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
