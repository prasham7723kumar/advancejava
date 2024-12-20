<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Department Details</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link href="stylesheet1.css" rel="stylesheet">
</head>
<body>
	<div class="form-container">
		<h2 class="form-title">Department Details</h2>
		<form id="1" name="1" method="post" action="Adddepartment"
			onsubmit="return confirmSubmission();">
			<div class="form-group">
				<label for="dname">Name</label> <input type="text" id="dname"
					name="dname" class="form-control" placeholder="Enter name" required>
			</div>
			<div class="form-group">
				<label for="dloc">Location</label> <input type="text" id="dloc"
					name="dloc" class="form-control" placeholder="Enter location">
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
