<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Details</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link href="stylesheet1.css" rel="stylesheet">
</head>
<body>
	<div class="form-container">
		<h2 class="form-title">Employee Details</h2>
		<form id="1" name="1" method="post" action="employeeadd"
			onsubmit="return confirmSubmission();">
			<div class="form-group">
				<label for="empname">Employee Name</label> <input type="text"
					id="empname" name="empname" class="form-control"
					placeholder="Enter Employee Name" required>
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <select id="gender" name="gender"
					class="form-control" required>
					<option value="">Select Gender</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Others">Others</option>
				</select>
			</div>
			<div class="form-group">
				<label for="job">Job</label> <input type="text" id="job" name="job"
					class="form-control" placeholder="Enter Job" required>
			</div>
			<div class="form-group">
				<label for="empstatus">Employee Status</label> <select
					id="empstatus" name="empstatus" class="form-control" required>
					<option value="">Select Status</option>
					<option value="Active">Active</option>
					<option value="Inactive">Inactive</option>
				</select>
			</div>

			<div class="form-group">
				<label for="deptno">Department No</label> <input type="text"
					id="deptno" name="deptno" class="form-control"
					placeholder="Enter Department No" required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Submit</button>
		</form>
	</div>
	<script>
		function confirmSubmission() {
			return confirm("Are you sure you want to submit?");
		}
	</script>
</body>
</html>
