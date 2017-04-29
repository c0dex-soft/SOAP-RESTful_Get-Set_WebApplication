<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<h2>${title}</h2>
<p><b>Error Message:</b> ${errormessage}</p>
<p><b>Error Code: </b>
<c:forEach var="element" items="${errorcode}">
	<span style="color: #c70909;"><c:out value="${element}"></c:out></span></br>
</c:forEach>
</p>
<p><a href="${pageContext.request.contextPath}/">Home stranica</a></p>
</body>
</html>