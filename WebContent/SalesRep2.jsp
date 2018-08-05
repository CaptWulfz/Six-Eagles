<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.SalesRepdao" %>
<%@page import= "model.Orders" %>
<%@page import = "model.Client" %>
<%@page import = "model.salesRep" %>

<!DOCTYPE html>
<%
    String startDate=(String)request.getAttribute("start");
    String endDate=(String)request.getAttribute("end");
    ArrayList<Orders>order = (ArrayList<Orders>) request.getAttribute("ordersList");
    ArrayList<Client> clientList = (ArrayList<Client>) request.getAttribute("clientList");

%>
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
			<div class="page-heading"><b>Client Sales Report</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
				</div> <!-- /div-action -->				
				<div class="col-sm-10">
        <h2>Sales Report from:<%=startDate%> to <%=endDate%></h2>
        <table class="table table-hover" align = "center">
						<thead>
							<tr>
	                            <th><center>Purchase Order No.</center></th>
	                            <th><center>Client Name</center></th>
	                            <th><center>Delivery Receipt No.</center></th>
	                            <th><center>Order Date</center></th>
	                            <th><center>Delivery Date</center></th>
	                            <th><center>Status</center></th>
							</tr>
							<% for(int i = 0; i < order.size(); i++) {
                         		Orders o = order.get(i);
                        	  	Client c = clientList.get(i); %>
                                	<tr>
                                    	<td><center><%=o.getPurchaseOrderNum()%></center></td>
                                    	<td><center><%=c.getClientName() %></center>
                                        <td><center><%=o.getDeliveryrecieptNum()%></center></td>
                                        <td><center><%=o.getOrderdate()%></center></td>
                                        <td><center><%=o.getDeliverydate()%></center></td>
                                        <td><center><%=o.getStatusDetails()%></center></td>
                                		<td>
                                			<form method = "post" action = "/Six_Eagles/vieworderdetails">
                                				<center><button type = "submit" name = "submitBtn" value = "<%=o.getPurchaseOrderNum() %>" class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View Order Details</button></center>
                                			</form>
                                		<td>
                                    </tr>
                             <%}%>
						</thead>
					</table>
        
              <button onclick="myFunction()"  class = "noprint">Print</button>

        <script>
            function myFunction() {
            	window.print();
            }
        </script>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
</div>		
		
		

		

  </div>
  <!-- /modal-dailog -->
</div>

	</body>
	<style>
		@media print {
	   		.breadcrumb {
	   			visibility: hidden;
	   		}
	   		
	   		.btn {
	   			visibility: hidden;
	   		}
	   		
	   		.noprint {
	   			visibility: hidden;
	   		}
	   	}
			
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