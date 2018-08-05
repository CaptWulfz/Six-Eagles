<%-- 
    Document   : CreateUser
    Created on : 02 20, 18, 1:14:08 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE0 html>
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
					<b>Update User Credentials</b>
				</div>
				<div class = "messages">
					
				<div class="panel-body">
					<form class="form-horizontal" action="submitCreateUserRequest" method = "POST">
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Firstname:</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" name = "Firstname" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Lastname:</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" name = "Lastname" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Old Username:</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" name = "OldUsername" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">New Username:</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" name = "Username" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Old Password:</label>
							<div class="col-sm-7">
								<input type="password" class="lorem form-control" name = "OldPassword" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">New Password:</label>
							<div class="col-sm-7">
								<input type="password" class="lorem form-control" name = "Password" id="col1" style="width: 300px;" required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Re-Enter Password:</label>
							<div class="col-sm-7">
								<input type="password" class="lorem form-control" name = "RePassword" id="col1" style="width: 300px;" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="col1">Address:</label>
							<div class="col-sm-7">
								<input type="text" class="lorem form-control" name = "Address" id="col1" style="width: 300px;" required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-5" for="col2">Staff Position to Update: </label>
							<div class="col-sm-7">
								<select class="form-control" id="productName" name="Position" style = "width : 300px" required>
									<option value = ""></option>
									<option value = "Admin">Admin</option>
									<option value = "Staff">Plant Head</option>										
								</select>
							</div>
						</div>
						
						<% String errorMessage = (String) request.getAttribute("errorMessage"); 
						   if (errorMessage != null) { %>
							<div style = "color:red">
								<b><center><% out.println(errorMessage); %></center></b>
							</div>
						<% } %>
						
						<button type="submit" name = "submitButton" value = "submitUserRequest" class="btn btn-primary" style="margin-left: 35%;"><i class="glyphicon glyphicon-log-in"></i> Submit</button>
						<button type="submit" name = "submitButton" value = "cancelUserRequest" class="btn btn-default">Cancel</button>
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