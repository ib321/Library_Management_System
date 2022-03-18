<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-Management-System</title>

<style type="text/css">
html, .hero-image {
	background-color: grey;
	background-image:
		url("https://w0.peakpx.com/wallpaper/972/48/HD-wallpaper-stack-of-books-blue-background-education-concepts-books-library-school-learning-concepts.jpg");
	height: 500px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
.card {
  height: 350px;
  width: 350px !important;
  display: inline-block;
}
.card {
 background: linear-gradient(150deg, #f731db, #4600f1 100%);
  position: relative;
  margin: 0.5rem 0 1rem 0;
  -webkit-transition: -webkit-box-shadow 0.25s;
  transition: -webkit-box-shadow 0.25s;
  transition: box-shadow 0.25s;
  transition: box-shadow 0.25s, -webkit-box-shadow 0.25s;
  border-radius: 2px;
  margin-left: 15px;
}
.button{
  width: 150px;
  display: block;
  margin: 0 auto;
  color: #4600f1;
  border-radius: 50px;
  padding: 1em;
  background: white;
  border: none;
  font-weight: bold;
}
.anchor1 {
	background-color: white;
	border: 2px solid #42f4ce;
	border-radius: 5px;
	color: black;
	padding: 10px;
	text-decoration: none;
}

.anchor1:hover {
	background-color: #42f4ce;
	color: red;
}

.anchor2 {
	background-color: white;
	border: 2px solid #b0f0f2;
	border: radius 5px;
	color: black;
	padding: 10px;
	text-decoration: none;
}

.anchor2:hover {
	background-color: #42f4ce;
	color: red;
}
</style>
<body>
	<div align="center">

		<h1 style="color: white;">LIBRARY MANAGEMENT SYSTEM</h1>
		<br /> <br />
		<div class="card">
		<h2>LOGIN</h2>
		<br /> <br />
		<form action="/home" method="get">
			<b style="font-size: 30px">Username:</b> 
			<input class="anchor1"
			type="text" name="name" placeholder="User Name" id="name" required>
			<br> <br> 
			<b style="font-size: 30px;">Password:</b> 
			<input
				class="anchor2" type="password" placeholder="Password" name="password"
				id="password" required> <br> <br> 
				
		<input class="button" type="Submit" id="validate" value="Login">
		<br>
		</form>
		<form action="/registerUser" method="get">
		<input class="button" type="Submit" id="register" value="Create New Account">
		</form>
	</div>
	</div>
	<div  align="center" ><h2>${outString}</h2></div>

</body>
</head>
</html>