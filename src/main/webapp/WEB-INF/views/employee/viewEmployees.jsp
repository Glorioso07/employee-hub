<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>Employee Hub</title>
		<link rel="stylesheet" href="../css/style.css">
	</head>
	<body>
		<div class="wrapper">
			<a class="back" href="/">Home</a><br /><br />
			<h1>View Employee</h1>
			<c:if test="${not empty employee}">
				<div>
					<label>Code: </label>
					<b>${employee.getEmployeeCode()}</b>
				</div>
				<div>
					<label>First name: </label>
					<b>${employee.getFirstName()}</b>
				</div>
				<div>
					<label>Last name: </label>
					<b>${employee.getLastName()}</b>
				</div>
				<div>
					<label>Department name: </label>
					<b>${employee.getDepartment().getDepartmentName()}</b>
				</div>
				<div>
					<label>Email: </label>
					<b>${employee.getEmail()}</b>
				</div>
				<div>
					<label>Contact number: </label>
					<b>${employee.getContactNumber()}</b>
				</div>
				<div>
					<label>Gender: </label>
					<b>${employee.getGender()}</b>
				</div>
				<div>
					<label>Date of birth: </label>
					<b>
						<fmt:formatDate value="${employee.getDob()}" type="date" pattern="yyyy-MM-dd" /></b>
				</div>
				<c:if test="${not empty currentEmployeeAddress}">
					<div>
						<label>Current address: </label>
						<b>${currentEmployeeAddress.getAddressLine1()} ${currentEmployeeAddress.getAddressLine2()},
								${currentEmployeeAddress.getAddressTown()}, ${currentEmployeeAddress.getAddressPostcode()},
								${currentEmployeeAddress.getAddressCountry()}</b>
					</div>
				</c:if>
			</c:if>
		</div>
	</body>
</html>
