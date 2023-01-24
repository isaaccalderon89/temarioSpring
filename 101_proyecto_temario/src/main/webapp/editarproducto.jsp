<%@page import="modelo.beans.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Producto producto = (Producto)request.getAttribute("producto");%>
	
	<p>Descripcion : <%= producto.getDescripcion() %></p>
</body>
</html>