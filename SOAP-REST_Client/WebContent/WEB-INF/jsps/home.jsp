<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<title>Customer Details Form</title>
<style>
table {
	border-color: 1px solid red;
	width: 100%;
}

#customer_form {
	padding: 20px;
	width: 40%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(odd) {
	background-color: #f2f2f2
}

th {
	background-color: #4a5db8;
	color: white;
	font-weight: normal;
}

td {
	width: 75%
}

input[type="text"], input[type="date"] {
	width: 100%;
}

input[type="submit"] {
	font-size : small;
	width: 40%;
}
</style>
</head>
<body>
	<div id="customer_form">
		<sf:form action="${pageContext.request.contextPath}/soap/getcustomer"
			modelAttribute="customer" method="POST">
			<table>
				<tr>
					<th>Customer ID:</th>
					<td><sf:input type="text" path="customerId" /></td>
				</tr>
				<tr>
					<th>First name:</th>
					<td><sf:input type="text" path="firstName" /><br>
					<span style="font-size: small; color: #a7272b; font-weight: normal;"><sf:errors
								path="firstName"></sf:errors></span></td>
				</tr>
				<tr>
					<th>Last name:</th>
					<td><sf:input type="text" path="lastName" /></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><sf:input type="text" path="email" /></td>
				</tr>
				<tr>
					<th>Phone number:</th>
					<td><sf:input type="text" path="phoneNumber" /></td>
				</tr>
				<tr>
					<th style="background-color: #ab4c15; text-align: center;">SOAP</th>
					<td style="background-color: #ab4c15;">
					<input type="submit" value="GetCustomerDetails" style="float: left;">
					<input type="submit" value="SetCustomerDetails" style="float: right;"
						formaction="${pageContext.request.contextPath}/soap/setcustomer"
						method="POST"></td>
				</tr>
				<tr>
					<th style="background-color: #e07c00; text-align: center;">RESTful</th>
					<td style="background-color: #e07c00;">
					<input type="submit" value="GetCustomerDetails" style="float: left;"
						formaction="${pageContext.request.contextPath}/rest/getcustomer"
						method="POST">
					<input type="submit" value="SetCustomerDetails"
						style="float: right;"
						formaction="${pageContext.request.contextPath}/rest/setcustomer"
						method="POST"></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>