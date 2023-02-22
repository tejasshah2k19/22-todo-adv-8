<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ToDoApp | Reset Password!!</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-6">
				<h2>Update your Password</h2>
				<h4>Please Check your Inbox!!!</h4>
				<form class="form-horizontal" action="ResetPasswordServlet"
					method="post">
					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							placeholder="email" class="form-control" />
					</div>

					<div class="form-group">
						<label>OTP</label> <input type="text" name="otp" placeholder="OTP"
							class="form-control" />
					</div>


					<div class="form-group">
						<label>Password</label> <input type="text" name="password"
							placeholder="Password" class="form-control" />
					</div>

					<button type="submit" class="btn btn-primary">Update My
						Password</button>

					${error }

				</form>
				<br> <a href="Signup.jsp">Signup</a> <br> <a
					href="Login.jsp">Login</a>

			</div>
		</div>
	</div>
</body>
</html>