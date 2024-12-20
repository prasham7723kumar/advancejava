<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link href="stylesheet1.css" rel="stylesheet">
</head>
<body>
	<div class="form-container">
		<form name="AdminForm" action="login" method="post"
			onsubmit="return confirmSubmission();">
			<h3 class="form-title">Login</h3>
			<div class="form-group">
				<label for="email">Email ID</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="Enter your email" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter your password" required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Login</button>
		</form>
	</div>
	<script>
        function confirmSubmission() {
            return confirm("Are you sure you want to submit?");
        }

        // Display alert if an error message is present
        <%String errorMessage = (String) request.getAttribute("errorMessage");%>
        <%if (errorMessage != null) {%>
            alert("<%=errorMessage%>
		");
	<%}%>
		
	</script>
</body>
</html>
