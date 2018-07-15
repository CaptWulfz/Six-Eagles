<%-- 
    Document   : viewrawmats
    Created on : Apr 16, 2018, 6:05:10 PM
    Author     : Roano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.Supplierrawmatsdao" %>
<%@page import= "model.supplierlists" %>
<!DOCTYPE html>

<%
    int code = (Integer)request.getAttribute("codew");
    
    
    //ArrayList<product>prod = productdao.viewproduct();
    //ArrayList<ingredients>ing=ingredientsdao.viewIngredient();
    ArrayList<supplierlists>ilist=Supplierrawmatsdao.viewrawmatssupplier(code);
    
    //boolean test = ilist.isEmpty();
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
    
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="home.jsp">Home</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>View Raw Materials</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">			
				
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
                                                    <th><center>Supplier</center></th>
                                                    <th><center>Raw Material</center></th>
                       
                                                    
						</tr>
                                                
                                                
                                                <%
                                                    
                                                    for(supplierlists s : ilist){
                                                        
                                                %>
                                                
                                                <tr>
                                                    <td><center><%=s.getSupplier()%></center></td>
                                                    <td><center><%=s.getRawmats()%></center></td>
                                                    
                                                </tr>
                                                <% } %>
					</thead>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
	      <!-- /modal-footer -->
     	</form>
	     <!-- /.form -->
    </div>
    <!-- /modal-content -->

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
