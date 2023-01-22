<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Tabla 1 al 10</h1>
	<table border ="1">
	<%for(int i=1;i<=10;i++){%>
	<tr>
		<%for(int k=1; k<=10;k++){%>
			<td><%=i*k%></td>
			<%} %>
	</tr>
	<%} %>
	</table>
</body>
<!-- Como hemos indicando, una página JSP se compone de texto HTML y bloques de código Java. El código Java debe separarse
del HTML mediate los simbolos -->
</html>