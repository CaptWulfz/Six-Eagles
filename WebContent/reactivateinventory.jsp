<%-- 
    Document   : inventory
    Created on : 02 20, 18, 1:22:15 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "dao.productdao" %>
<%@page import= "model.product" %>
<%@page import = "dao.ingredientsdao" %>
<%@page import= "model.ingredients" %>
<!DOCTYPE html>

<%
    
    ArrayList<product>prod = productdao.viewproductdeactive();
    ArrayList<ingredients>ing=ingredientsdao.viewIngredientactive();
%>

<html>
    <jsp:include page="header.jsp"/>
<div class="modal-header">
	<div class="row">
	<div class="col-md-12">

		<ol class="breadcrumb">
		  <li><a href="/Six_Eagles/home">Home</a></li>		
		  <li><a href="/Six_Eagles/inventory">View Products</a></li>
		  <li><a href="/Six_Eagles/productPhysicalCount">Product Physical Count</a></li>
		  <li><a class = "active" >Reactivate Product</a></li>
		  <li><a href="/Six_Eagles/updateInventory">Produce Product</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="page-heading"><b>Products</b></div>
			</div> <!-- /panel-heading -->
			<div class="panel-body">
				<div class="div-action pull pull-right" style="padding-bottom:20px;">
				 <div class="modal fade" id="myModal" role="dialog">
                                                        <div class="modal-dialog">

                                                          <!-- Modal content-->
                                                          <div class="modal-content">
                                                              <form class="form-horizontal" id="submitRawMaterialsForm" action="addIngredientlists" method="POST">
                                                            <div class="modal-header">
                                                              <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                              <h4 class="modal-title">Modal Header</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Product</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="productadd" name="productadd" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(product p : prod){   
                                                                                                    %>
                                                                                        <option value="<%=p.getProductcode()%>"> <%=p.getProductname()%> </option>
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
                                                                <div class="form-group">
                                                                            <label class="control-label col-sm-3" for="col2">Ingredient</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                <div class="col-sm-8">

                                                                                    <select class="form-control" id="ingredientadd" name="ingredientadd" style = "width : 300px">
                                                                                                    <%
                                                                                                        for(ingredients I : ing){   
                                                                                                    %>
                                                                                        <option value="<%=I.getIngredientCode()%>"> <%=I.getIngredientName()%> </option>
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
                                                              <div class="form-group">
                                                                            <label for="productPrice" class="col-sm-3 control-label">Amount</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="amountadd" placeholder="Amount" name="amountadd" autocomplete="off">
                                                                                        </div>
                                                                    </div>
                                                                                    <div class="form-group">
                                                                            <label for="productPrice" class="col-sm-3 control-label">Unit</label>
                                                                            <label class="col-sm-1 control-label">: </label>
                                                                                        <div class="col-sm-8">
                                                                                          <input type="text" class="form-control" id="unitadd" placeholder="Uint" name="unitadd" autocomplete="off">
                                                                                        </div>
                                                                    </div>

                                                            </div>
                                                            <div class="modal-footer">
                                                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                              <button type="submit" name = "submit" class="btn btn-success" id="createBrandBtn" data-loading-text="Loading..." autocomplete="off">Save Changes</button>
                                                            </div>
                                                              </form>
                                                          </div>

                                                        </div>
                                                      </div>
				</div> <!-- /div-action -->				
				
				<table class="table" id="manageProductTable">
					<thead>
						<tr>
	                        <th><center>Name</center></th>
	                        <th><center>Price</center></th>
	                        <th><center>Stocks (in Pcs.)</center></th>
	                        <th><center>Threshold</center></th>
	                        <th><center>Ceiling</center></th>
	                        <th><center>Status</center></th>
						</tr>                     
                           <% for (product p : prod){ %>     
	                           <tr>
	                               <td><center><%=p.getProductname()%></center></td>
	                               <td><center><%=p.getProductprice()%></center></td>
	                               <td><center><%=p.getStock()%></center></td>
	                               <td><center><%=p.getThreshold()%></center></td>
	                               <td><center><%=p.getCeiling()%></center></td>
	                               <td>
	                              		<form method = "post" action = "/Six_Eagles/viewIngredientslist">
	                              		<center><button type = "submit" name = "submitButton" value = "<%=p.getProductcode()%>" class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>View ingredients</button></center>
	                             		</form>
	                                <td>
	                                <td>
	                                	<form method = "post" action = "/Six_Eagles/reactivateproduct">
	                                		<center><button type = "submit" name = "submitButton" value = "<%=p.getProductcode()%>" class="btn btn-default button1"><i class="glyphicon glyphicon-plus-sign"></i>Reactivate</button></center>
	                                	</form>
	                                <td>
	                          	</tr>
                            <% } %>
					</thead>
				</table>
				<!-- /table -->

			</div> <!-- /panel-body -->
		</div> <!-- /panel -->		
	</div> <!-- /col-md-12 -->
</div> <!-- /row -->
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