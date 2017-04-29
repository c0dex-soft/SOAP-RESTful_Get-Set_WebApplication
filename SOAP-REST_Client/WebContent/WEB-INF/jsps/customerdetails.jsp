<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<title>Customer Details</title>
<style>
table {
	margin-top: 20px;
	
}

#customer_results {
	padding: 20px;
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
	width: 350px;
}
</style>
</head>
<body>
	<div id="customer_results">
		<h2>${title}</h2>

		<table>
			<tr>
				<th style="text-align: left">Customer ID:</th>
				<td style="color: #2b3e95; font-size: large; font-weight: bold;">#${customer.customerId}</td>
			</tr>
			<tr>
				<th style="text-align: left">First name:</th>
				<td>${customer.firstName}</td>
			</tr>
			<tr>
				<th style="text-align: left">Last name:</th>
				<td>${customer.lastName}</td>
			</tr>
			<tr>
				<th style="text-align: left">Email:</th>
				<td>${customer.email}</td>
			</tr>
			<tr>
				<th style="text-align: left">Broj:</th>
				<td>${customer.phoneNumber}</td>
			</tr>
		</table>
	</div>
	<p>
		<a style="margin-left: 20px;" href="${pageContext.request.contextPath}/">Home stranica</a>
	</p>
</body>
</html>