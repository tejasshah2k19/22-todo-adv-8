<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ToDoApp | List Task</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2>Your All Task</h2>

				<table class="table">

					<thead>
						<tr>
							<td>TaskId</td>
							<td>Title</td>
							<td>Description</td>
							<td>Date</td>
							<td>Status</td>
						</tr>
					</thead>

					<tbody>

						<%
							while (rs.next()) {
						%>
						<tr>
							<td><%=rs.getInt("todoId")%></td>
							<td><%=rs.getString("title")%></td>
							<td><%=rs.getString("description")%></td>
							<td><%=rs.getString("datetime")%></td>
							<td><%=rs.getString("isCompleted").equals("0")?"pending":"completed"%></td>
						</tr>
						<%
							}
						%>


					</tbody>

				</table>

			</div>
		</div>
	</div>
</body>
</html>