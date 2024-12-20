<%@ page import="com.firstweb.model.EmployeeModel"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Employee</title>
<!-- Link to external CSS file -->
<link rel="stylesheet" type="text/css" href="stylesheet1.css">
<!-- Bootstrap 5 CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="form-container">
		<h2 class="form-title text-center">Edit Employee</h2>

		<%
		EmployeeModel employee = (EmployeeModel) request.getAttribute("employee");
		if (employee != null) {
		%>
		<form action="UpdateEmployeeServlet" method="post">
			<div class="form-group mb-3">
				<label for="empno">Employee ID</label> <input type="text"
					class="form-control" id="empno" name="empno"
					value="<%=employee.getEmpno()%>" readonly>
			</div>
			<div class="form-group mb-3">
				<label for="empName">Employee Name</label> <input type="text"
					class="form-control" id="empName" name="empName"
					value="<%=employee.getEmpName()%>" required>
			</div>
			<div class="form-group mb-3">
				<label for="empJob">Employee Job</label> <input type="text"
					class="form-control" id="empJob" name="empJob"
					value="<%=employee.getEmpJob()%>" required>
			</div>
			<div class="form-group mb-3">
				<label for="gender">Gender</label> <select class="form-control"
					id="gender" name="gender" required>
					<option value="Male"
						<%="Male".equals(employee.getGender()) ? "selected" : ""%>>Male</option>
					<option value="Female"
						<%="Female".equals(employee.getGender()) ? "selected" : ""%>>Female</option>
					<option value="Other"
						<%="Other".equals(employee.getGender()) ? "selected" : ""%>>Other</option>
				</select>
			</div>

			<!-- Dropdown for Employee Status -->
			<div class="form-group mb-3">
				<label for="empStatus">Employee Status</label> <select
					class="form-control" id="empStatus" name="empStatus" required>
					<option value="Active"
						<%="Active".equals(employee.getEmpStatus()) ? "selected" : ""%>>Active</option>
					<option value="Inactive"
						<%="Inactive".equals(employee.getEmpStatus()) ? "selected" : ""%>>Inactive</option>
				</select>
			</div>

			<div class="form-group mb-3">
				<label for="deptNo">Department Number</label> <input type="text"
					class="form-control" id="deptNo" name="deptNo"
					value="<%=employee.getDeptNo()%>" required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Update</button>
		</form>
		<%
		} else {
		%>
		<div class="alert alert-danger">Employee details not found.
			Please try again.</div>
		<%
		}
		%>

	</div>

	<!-- Bootstrap 5 and Popper.js CDN for functionality -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
