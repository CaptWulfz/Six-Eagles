<%-- 
    Document   : home
    Created on : 02 20, 18, 1:04:30 AM
    Author     : Joshua Sultan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Users" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html>
    <head>
		<title>Eagle's Eye</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
    <style type="text/css">
	.ui-datepicker-calendar {
		display: none;
	}
</style>

<!-- fullCalendar 2.2.5-->
    <link rel="stylesheet" href="assests/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="assests/plugins/fullcalendar/fullcalendar.print.css" media="print">

<body onload = "displayMessage()">
	<div class="row">
		
		<div class="col-md-4">
			<div class="panel panel-success">
				<div class="panel-heading">
					
					<a href="inventory.jsp" style="text-decoration:none;color:black;">
						Total Products
						<span class="badge pull pull-right"></span>	
					</a>
					
				</div> <!--/panel-hdeaing-->
			</div> <!--/panel-->
		</div> <!--/col-md-4-->
	
			<div class="col-md-4">
				<div class="panel panel-info">
				<div class="panel-heading">
					<a href="orders.jsp?o=manord" style="text-decoration:none;color:black;">
						Total Orders
						<span class="badge pull pull-right"></span>
					</a>
						
				</div> <!--/panel-hdeaing-->
			</div> <!--/panel-->
			</div> <!--/col-md-4-->
	
		<div class="col-md-4">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<a href="inventory.jsp" style="text-decoration:none;color:black;">
						Low Stock
						<span class="badge pull pull-right"></span>	
					</a>
					
				</div> <!--/panel-hdeaing-->
			</div> <!--/panel-->
		</div> <!--/col-md-4-->
	
		<div class="col-md-4">
			<div class="card">
			  <div class="cardHeader" style="background-color:#245580;">
				<h3>Greetings,</h3>
			    <h1>
			    <% 	Users user = (Users) session.getAttribute("loginUser"); 
			    	if (user != null) 
			    		out.write(user.getUsername());
			    	else { %>
			    	User
			    	<% } %>
			    </h1>
			  </div>
	
			  <div class="cardContainer" style = "background-color: #FFFFFF;">
			    <p>Nice	to meet you!</p>
			  </div>
			</div> 
			<br/>
			<div class="card">
			  <div class="cardHeader" style="background-color:#245580;">
			    <h1></h1>
			  </div>
	
			  <div class="cardContainer" style = "background-color: #FFFFFF;">
			    <p></p>
			  </div>
			</div> 
			
	
			
	
		</div>
	
		<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading"> <i class="glyphicon glyphicon-calendar"></i> Calendar</div>
				<div class="panel-body">
					<div id="calendar"></div>
				</div>	
			</div>
			
		</div>
	
		
	</div> <!--/row-->

</body>
<!-- fullCalendar 2.2.5 -->
<script src="assests/plugins/moment/moment.min.js"></script>
<script src="assests/plugins/fullcalendar/fullcalendar.min.js"></script>


<script type="text/javascript">
	$(function () {
			// top bar active
	$('#navDashboard').addClass('active');

      //Date for the calendar events (dummy data)
      var date = new Date();
      var d = date.getDate(),
      m = date.getMonth(),
      y = date.getFullYear();

      $('#calendar').fullCalendar({
        header: {
          left: '',
          center: 'title'
        },
        buttonText: {
          today: 'today',
          month: 'month'          
        }        
      });
		
      <% String message = (String) request.getAttribute("successMessage");
	   System.out.println("THE MESSAGE IS: " + message);
	   if (message != null) { %>
	   		alert("<%=message%>");
	  <% } %>

    });
	

		
	

</script>
	<style>
		body {
			position: relative;
			background-color: #1E88E5;
		}


	</style>
</html>
