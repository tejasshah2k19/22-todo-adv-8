<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ToDoApp | New Task</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2>New Task</h2>

				<form class="form-horizontal" action="AddToDoServlet" method="post">
					<div class="form-group">
						<label>Title</label> <input type="text" placeholder="Title"
							name="title" class="form-control" />
					</div>

					<div class="form-group">
						<label>Description</label>
						<textarea name="description" placeholder="Description"
							class="form-control"></textarea>
					</div>

					<div class="form-group">
						<label>Date Time </label> <input type="text" name="datetime"
							placeholder="Task Date And Time" class="form-control" />
					</div>



					<button type="submit" class="btn btn-primary">Save </button>
				</form>
				<br><br>
				<A href="ListToDoServlet">My Task</A>
			</div>
		</div>
	</div>
</body>
</html>