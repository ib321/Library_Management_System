
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	background-color: white;
	border: 1px solid black;
}

body {
	background-color: white;
	background-image:
		url("https://w0.peakpx.com/wallpaper/339/896/HD-wallpaper-library-concepts-stack-of-books-education-background-books-background-with-books-books-on-the-table.jpg");
	background-size: cover;
}
</style>
</head>
<body>

	<h4 align="justify" style="color: white;">
		Go Back <br> <input type=button value="Back"
			onCLick="history.back()">
	</h4>

	<div align="center">
		<h1>Book List</h1>
		<%@ page import="com.lib.service.BookService"%>
	

		<table border="1">
			<tr>
				<th>BookNo</th>
				<th>BookName</th>
				<th>Author</th>
				<th>Category</th>
				<th>Available</th>
			<tr>

				<c:forEach var="book" items="${listname}">

					<tr>
						<td><center>${book.getId()}</center></td>
						<td>${book.getName()}</td>
						<td>${book.getAuthor()}</td>
						<td>${book.getCategory()}</td>
						<td>${BookService.checkAvailability(book.getReturnDate())}</td>
					</tr>
				</c:forEach>
		</table>
		<h4 style="color: white;">
			Click Below to Logout <br> <a style="color: green;"
				href="/login"><button>Logout</button> </a>
		</h4>

	</div>
</body>
</html>