<%-- 
    Document   : index
    Created on : Feb 22, 2018, 8:07:33 AM
    Author     : Desmond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
int sum=(Integer)request.getAttribute("IDK");





%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Result=<%= sum %></h1>
        <a href="HelloServlet">back</a>
    </body>
</html>
