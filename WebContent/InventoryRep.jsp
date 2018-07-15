<%-- 
    Document   : InventoryRep
    Created on : 04 13, 18, 4:42:02 AM
    Author     : AJ's Laptop
--%>

<%@page import="dao.invenRepdao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.InvenRepRaw"%>
<%@page import="model.InvenRepIng"%>
<%@page import="model.InvenRepProd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String startDate=(String)request.getAttribute("start");
    String endDate=(String)request.getAttribute("end");
    ArrayList<InvenRepRaw>inven=invenRepdao.viewInvenRaw(startDate,endDate);
    ArrayList<InvenRepIng>inven2=invenRepdao.viewInvenIng(startDate,endDate);
    ArrayList<InvenRepProd>inven3=invenRepdao.viewInvenProd(startDate,endDate);
    
    
%>
<html><html>
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
			<div class="page-heading"><b>Inventory Report</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
				</div> <!-- /div-action -->				
				<div class="col-sm-10">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Report</title>
    </head>
    <body>
        <h1>Inventory Report from:<%=startDate%> to <%=endDate%></h1>
        <table class="table" id="invenRepTable" name="Raw_table" border="1"> Raw Table:
		<thead>
			<tr>
                            <th><center>Audit ID</center></th>
                            <th><center>Raw Code</center></th>
                            <th><center>Name</center></th>
                            <th><center>Quantity</center></th>
                            <th><center>Audit Log</center></th>
			</tr>                        
                         <%for(InvenRepRaw c:inven){%>
                         
                        <tr>
                            <td><center><%=c.getAudit_id()%></center></td>
                            <td><center><%=c.getProdCode()%></center></td>
                            <td><center><%=c.getAuditNameRaw()%></center></td>
                            <td><center><%=c.getRW_Quantity()%></center></td>
                            <td><center><%=c.getAuditLog()%></center></td>
                            
                        </tr>
                        <%}%>
		</thead>
	</table>
          <table class="table" id="invenRepTable" name="Ing_table" border="1">Ingredients Table:
		<thead>
			<tr>
                            <th><center>Audit ID</center></th>
                            <th><center>Ingredient Code</center></th>
                            <th><center>Name</center></th>
                            <th><center>Quantity</center></th>
                            <th><center>Audit Log</center></th>
			</tr>                        
                         <%for(InvenRepIng c:inven2){%>
                         
                        <tr>
                            <td><center><%=c.getAudit_id()%></center></td>
                            <td><center><%=c.getProdCode()%></center></td>
                            <td><center><%=c.getAuditNameIng()%></center></td>
                            <td><center><%=c.getRW_Quantity()%></center></td>
                            <td><center><%=c.getAuditLog()%></center></td>
                            
                        </tr>
                        <%}%>
		</thead>
	</table>
                <table class="table" id="invenRepTable" name="Prod_table" border="1">Products Table:
		<thead>
			<tr>
                            <th><center>Audit ID</center></th>
                            <th><center>Product Code</center></th>
                            <th><center>Name</center></th>
                            <th><center>Quantity</center></th>
                            <th><center>Audit Log</center></th>
			</tr>                        
                         <%for(InvenRepProd c:inven3){%>
                         
                        <tr>
                            <td><center><%=c.getAudit_id()%></center></td>
                            <td><center><%=c.getProdCode()%></center></td>
                            <td><center><%=c.getAuditNameProd()%></center></td>
                            <td><center><%=c.getRW_Quantity()%></center></td>
                            <td><center><%=c.getAuditLog()%></center></td>
                            
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
    </body>
</html>
