<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.SalesRepdao" %>
<%@page import = "model.salesRep" %>

<!DOCTYPE html>
<%
    String startDate=(String)request.getAttribute("start");
    String endDate=(String)request.getAttribute("end");
    ArrayList<salesRep>cl=SalesRepdao.viewSales2(startDate,endDate);
    ArrayList<salesRep>cl2=SalesRepdao.viewSales(startDate,endDate);
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
			<div class="page-heading"><b>Sales Report</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
				</div> <!-- /div-action -->				
				<div class="col-sm-10">
        <h1>Sales Report from:<%=startDate%> to <%=endDate%></h1>
        <table class="table" id="salesRepTable" name="SR_table" border="1">
		<thead>
			<tr>
                            <th><center>Product Code</center></th>
                            <th><center>Product Name</center></th>
                            <th><center>Delivery Date</center></th>
                            <th><center>Quantity Ordered</center></th>
			</tr>                        
                         <%for(salesRep c:cl){%>
                        <tr>
                            <td><center><%=c.getProdCode()%></center></td>
                            <td><center><%=c.getProdName()%></center></td>
                            <td><center><%=c.getDeliveryDate()%></center></td>
                            <td><center><%=c.getQuantityOrdered()%></center></td>
                        </tr>
                        <%}%>
		</thead>
	</table>
        <table class="table" id="salesRepTable2" name="SR_table2" border="1">
		<thead>
			<tr>
                            <th><center>Product Code</center></th>
                            <th><center>Product Name</center></th>
                            <th><center>Total</center></th>
			</tr>                        
                         <%for(salesRep c:cl2){%>
                        <tr>
                            <td><center><%=c.getProdCode()%></center></td>
                            <td><center><%=c.getProdName()%></center></td>
                            <td><center><%=c.getTotal()%></center></td>
                        </tr>
                        <%}%>
		</thead>
	</table>
              <button onclick="myFunction()" placeholder="Print">Print</button>

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