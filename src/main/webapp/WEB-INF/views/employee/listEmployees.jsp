<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Employee Hub</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="wrapper">
			<a class="back" href="/">Home</a><br /><br />
			<h1>All Employees</h1>
			<c:if test="${employees.size() > 0}">
				<table>
					<thead>
					<tr>
						<th>Code</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Department name</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.getEmployeeCode()}</td>
							<td>${employee.getFirstName()}</td>
							<td>${employee.getLastName()}</td>
							<td>${employee.getDepartment().getDepartmentName()}</td>
							<td>
								<a class="btn" href="<%=request.getContextPath()%>/employee/${employee.getId()}">Detail</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</body>
</html>
