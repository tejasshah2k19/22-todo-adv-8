<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%
		int rsInComplete = (Integer) request.getAttribute("rsInComplete");
		int rsComplete = (Integer) request.getAttribute("rsComplete");
	%>

	${cookie.userName.value }
	<br>
	<Br> TotalPending :
	<%=rsInComplete%><br> TotalCompleted :
	<%=rsComplete%><br>
	<br>


	<a href="AddToDo.jsp">Add ToDo</a>
</body>
</html>