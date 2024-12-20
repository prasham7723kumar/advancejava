<!DOCTYPE html>
<%@page import="com.firstweb.model.AddDepartment"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Department</title>
<link rel="stylesheet" type="text/css" href="stylesheet1.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="marquee-container">
		<div class="marquee-text">Welcome to the Department Management
			System</div>
	</div>
	<div class="form-container">
		<h2 class="form-title">Edit Department</h2>
		<form action="UpdateDepartmentServlet" method="post">
			<div class="form-group mb-3">
				<label for="deptNo">Department ID</label> <input type="text"
					class="form-control" id="deptNo" name="deptNo"
					value="<%=((AddDepartment) request.getAttribute("department")).getDeptNo()%>"
					readonly>
			</div>
			<div class="form-group mb-3">
				<label for="deptName">Department Name</label> <input type="text"
					class="form-control" id="deptName" name="deptName"
					value="<%=((AddDepartment) request.getAttribute("department")).getDeptName()%>"
					required>
			</div>
			<div class="form-group mb-3">
				<label for="location">Location</label> <input type="text"
					class="form-control" id="location" name="location"
					value="<%=((AddDepartment) request.getAttribute("department")).getLocation()%>"
					required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Update</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
