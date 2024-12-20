<%@page import="com.firstweb.model.AddDepartment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.firstweb.model.EmployeeModel"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>List of Departments</h2>
	<%
	List<AddDepartment> list = (List<AddDepartment>) request.getAttribute("department");
	%>

	<div class="container mt-5">
		<h2 class="text-center mb-4">Depatment Data</h2>
		<table class="table table-striped table-hover table-bordered">
			<thead class="table-dark">
				<tr>
					<th>DEPARTMENT ID</th>
					<th>DEPARTMENT Name</th>
					<th>DEPARTMENT Location</th>
					<th>EDIT DEPARTMENT</th>

				</tr>
			</thead>

			<tbody>
				<%
				for (AddDepartment e1 : list) {
				%>
				<tr>
					<td><%=e1.getDeptNo()%></td>
					<td><%=e1.getDeptName()%></td>
					<td><%=e1.getLocation()%></td>
					<td>
						<form method="get" action="UpdateDepartmentServlet">
							<input type="hidden" name="deptNo" value="<%=e1.getDeptNo()%>">
							<button type="submit" class="btn btn-warning btn-sm">Edit</button>
						</form>
					</td>


					<%
					}
					%>
				</tr>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>





</body>
</html>