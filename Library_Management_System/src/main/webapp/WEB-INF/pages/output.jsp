<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library Management System</title>
</head>
<body>
<div align="center">
		<h1>Book List</h1>
		
		<table border="1">

			<th>BookNo</th>
			<th>BookName</th>
			<th>Author</th>
			<th>Category</th>
			<th>Available</th>

			<c:forEach var="b" items="${listname}">
				<tr>

					<td>${b.getId()}</td>
					<td>${ b.getName()}</td>
					<td>${b.getAuthor()}</td>
					<td>${b.getCategory()}</td>
					<td>Will do</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>