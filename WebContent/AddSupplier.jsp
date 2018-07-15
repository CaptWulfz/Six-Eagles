<%-- 
    Document   : AddSupplier
    Created on : 02 20, 18, 1:11:28 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<script>
		$(document).ready(function(){
		  var date_input=$('input[name="date"]'); //our date input has the name "date"
		  var container=$('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
		  var options={
			format: 'mm-dd-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		  };
		  date_input.datepicker(options);
		})
	</script>   
		<div class="area container-fluid">
			<div class="panel panel-default" style="width: 100%; margin-left: 5%;">
				<div class="panel-heading">
					<b>Create Supplier</b>
				</div>
				<div class = "messages">
					
							<i class = "glyphicon glyphicon-exclamation-sign"></i>
							'.$value.'</div>';
						}
					}
					
					?>
				<div class="panel-body">
					<form class="form-horizontal" action="
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Supplier Name:</label>
							<div class="col-sm-7">
								<select class="form-control" id="SupplierName" name="SupplierName" style = "width : 300px">
									<option value = ""></option>
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Number of Ingredients to Add:</label>
							<div class="col-sm-7">
								<input type="number" class="lorem form-control" name = "NumIngredient" id="col1" style="width: 300px;" required>
							</div>
						</div>
						
						<button type="submit" name = "submit" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Next Step</button></a>
						<a href = "home.jsp" <button type="button" class="btn btn-default">Cancel</button></a>
					</form>
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
			padding-left: 200px;
			padding-right: 200px;
			background-color: #1E88E5;
			height: 100%;
		}
		
		.panel-body {
			width: 100%;
			margin-left: 0px;
		}
		
		.form-horizontal .lorem, .ipsum, .dolor, .sit, .amet {
			margin-left: 0px;
			width: 75%;
		}
		
		.btn {
			margin-top: 15px;
			margin-right: 5px;
		}
	</style>
</html>
