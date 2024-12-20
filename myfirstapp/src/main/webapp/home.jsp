<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.firstweb.model.EmployeeModel"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Employee Management</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center mb-4">Employees Data</h2>
		<table class="table table-striped table-hover table-bordered">
			<thead class="table-dark">
				<tr>
					<th>EMPLOYEE ID</th>
					<th>EMPLOYEE Name</th>
					<th>EMPLOYEE GENDER</th>
					<th>EMPLOYEE JOB</th>
					<th>EMPLOYEE STATUS</th>
					<th>EMPLOYEE DEPARTMENT</th>
					<th>ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<%
				// Assuming 'employee' attribute contains the list of employees
				List<EmployeeModel> list = (List<EmployeeModel>) request.getAttribute("employee");
				for (EmployeeModel e : list) {
				%>
				<tr>
					<td><%=e.getEmpno()%></td>
					<td><%=e.getEmpName()%></td>
					<td><%=e.getGender()%></td>
					<td><%=e.getEmpJob()%></td>
					<td><%=e.getEmpStatus()%></td>
					<td><%=e.getDeptNo()%></td>
					<td>
						<form action="UpdateEmployeeServlet" method="get"
							style="display: inline;">
							<input type="hidden" name="empno" value="<%=e.getEmpno()%>">
							<button type="submit" class="btn btn-primary btn-sm">Edit</button>
						</form>
						<form action="DeleteEmployee" method="post"
							style="display: inline;">
							<input type="hidden" name="id" value="<%=e.getEmpno()%>">
							<button type="submit" class="btn btn-danger btn-sm">Delete</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
