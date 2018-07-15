<%-- 
    Document   : generateReports
    Created on : 04 12, 18, 12:06:19 PM
    Author     : AJ's Laptop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
    <jsp:include page="header.jsp"/>
    <script src="jquery-3.3.1.min.js"></script>
    <body da ta-spy="scroll" data-target=".navbar" data-offset="50">
        
		<script>
			$(document).ready(function(){
			$('[data-toggle="popover"]').popover(); 
			}); 
		</script>	
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="home.jsp">Home</a></li>		
		  <li><a class = "active">Sales Report</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Sales Report</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
								
				<div class="col-sm-10">
                               
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Report</title>
    </head>
    <body>
        <form action="ReportsServ" method="POST" name="viewReport">
           Report Coverage:</br>
           <input type="date" name="start">-<input type="date" name="end"></br>
           Type of Report:</br>
            <select id="drop" name="drop">
               <option Value=1>Sales Report</option>
               <option Value=2>Inventory Report</option>
            </select>
           </br>
          <input type="submit" value="submit"></br>
        </form>
    </body>
    </div> <!-- /div-action -->
                                </div>
                        </div>
                </div>
            </div>
            </div>
    </div>
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
