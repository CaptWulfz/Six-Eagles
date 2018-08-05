<%-- 
    Document   : InventoryRep
    Created on : 04 13, 18, 4:42:02 AM
    Author     : AJ's Laptop
--%>

<%@page import="dao.invenRepdao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.InvenRepRaw"%>
<%@page import="model.InvenRepIng"%>
<%@page import = "model.ingredients" %>
<%@page import = "model.product" %>
<%@page import="model.InvenRepProd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    ArrayList<ingredients> ingrList = (ArrayList<ingredients>) request.getAttribute("ingrList");
    ArrayList<product> prodList = (ArrayList<product>) request.getAttribute("prodList");
    
    
%>
<html>
    <jsp:include page="header.jsp"/>
    <script src="jquery-3.3.1.min.js"></script>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Report</title>
    </head>
    <script>
			$(document).ready(function(){
			$('[data-toggle="popover"]').popover(); 
			}); 
			
			 function myFunction() {
		            window.print();
		     }
	</script>	
    <body data-spy="scroll" data-target=".navbar" data-offset="50">
		<div class = "area container-fluid">
			<ol class="breadcrumb">
			  <li><a href="/Six_Eagles/home">Home</a></li>		
			  <li><a class = "active">Sales Report</a></li>
			</ol>

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="page-heading"><b>Inventory Report</b></div>
				</div> <!-- /panel-heading -->
				<div class="panel-body">
			        <h2>Inventory Report Today: <%=request.getAttribute("dateToday") %></h2>
			        <h3>Ingredients:</h3>
			        <table class="table" id="invenRepTable" border="1"> 
						<thead>
							<tr>
	                            <th><center>Ingredient Code</center></th>
	                            <th><center>Ingredient Name</center></th>
	                            <th><center>Quantity</center></th>
							</tr>                        
	                        <% for(ingredients i : ingrList) { %>
		                        <tr>
		                            <td><center><%=i.getIngredientCode()%></center></td>
		                            <td><center><%=i.getIngredientName()%></center></td>
		                            <td><center><%=i.getStock()%></center></td>  
		                        </tr>
	                        <%}%>
						</thead>
					</table>
					
					<h3>Products:</h3>
					<table class="table" id="invenRepTable" border="1"> 
						<thead>
							<tr>
	                            <th><center>Product Code</center></th>
	                            <th><center>Product name</center></th>
	                            <th><center>Available Stock</center></th>
							</tr>                        
                         	<% for(product p :prodList) { %>
	                        	<tr>
		                            <td><center><%=p.getProductcode()%></center></td>
		                            <td><center><%=p.getProductname()%></center></td>
		                            <td><center><%=p.getStock()%></center></td>    
	                        	</tr>
                        	<%}%>
						</thead>
					</table>
                
     				<button onclick="myFunction()" class = "noprint" placeholder="Print">Print</button>
				</div>
			</div>
		</div>
    </body>
     <style>
       	@media print {
       		.breadcrumb {
       			visibility: hidden;
       		}
       		
       		.noprint {
       			visibility: hidden;
       		}
       	}
     </style>
</html>
