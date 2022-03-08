<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library Management System</title>
<style>
h1 {
	color: #0ae312;
}

table, th, td {
	width: 40%;
	background-color: #e3520a;
	border: 1px solid black;
}
body{
	background-color:yellow;
	background-image:url("https://w0.peakpx.com/wallpaper/339/896/HD-wallpaper-library-concepts-stack-of-books-education-background-books-background-with-books-books-on-the-table.jpg");
	background-size:cover;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Book List</h1>
		<%@ page import="com.lib.bo.BookBO"%>
		<%@ page import="com.lib.exception.BookNotFoundException"%>

		<table border="1">
			<tr>
				<th>BookNo</th>
				<th>BookName</th>
				<th>Author</th>
				<th>Category</th>
				<th>Available</th>
			<tr>

				<c:forEach var="b" items="${listname}">

					<tr>

						<td>${b.getId()}</td>
						<td>${ b.getName()}</td>
						<td>${b.getAuthor()}</td>
						<td>${b.getCategory()}</td>
						<td>${BookBO.checkAvailability(b.getReturnDate())}</td>
					</tr>
				</c:forEach>
		</table>
		 <h4 style="color:white;">
			 Below is the Link to Logout <br><a style="color:green;" href="/LibraryManagement/">Click Me To Logout</a>
		</h4>
		
	</div>
</body>
</html>