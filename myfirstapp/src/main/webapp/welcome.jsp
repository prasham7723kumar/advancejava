<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<!-- Bootstrap 4 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Custom CSS -->
<style>
body {
	background-color: #f8f9fa;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
}

.navbar-custom {
	background-color: #10486e;
	padding: 15px 0;
}

.navbar-custom .btn {
	width: 100%;
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
	border-radius: 5px;
}

.sub {
	background-color: #10486e;
	color: white;
}
</style>
</head>
<body>
	<div class="container-fluid navbar-custom">
		<div class="row">
			<div class="col-3">
				<form action="admin" method="post">
					<button type="submit" class="btn sub">Display Employee</button>
				</form>
			</div>
			<div class="col-3">
				<form method="post" action="addemployee.jsp">
					<button type="submit" class="btn sub">Add Employee</button>
				</form>


			</div>
			<div class="col-3">
				<form action="adddept.jsp">
					<button type="submit" class="btn sub">Add Department</button>
				</form>
			</div>
			<div class="col-3">
				<form action="depdisplay" method="post">
					<button type="submit" class="btn sub">Display Department</button>
				</form>
			</div>
		</div>
	</div>

	<div class="welcome-text text-center mt-5">
		<h2>Welcome to the Home Page!</h2>
	</div>

	<footer class="text-center mt-auto py-3">
		<p>© 2024 Your Company. All Rights Reserved.</p>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
