<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<style type="text/css">
html {
	background-color: grey;
	background-image:
		url("https://w0.peakpx.com/wallpaper/972/48/HD-wallpaper-stack-of-books-blue-background-education-concepts-books-library-school-learning-concepts.jpg");
	height: 500px; background-position : center; background-repeat :
	no-repeat;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}
</style>

<script>
var divs = new Array();
divs[0] = "errFirst";
divs[1] = "errLast";
divs[2] = "errEmail";
divs[3] = "errUid";
divs[4] = "errPassword";
divs[5] = "errConfirm";

function validate() {
    var inputs = new Array();
    inputs[0] = document.getElementById('first').value;
    inputs[1] = document.getElementById('last').value;
    inputs[2] = document.getElementById('email').value;
    inputs[3] = document.getElementById('uid').value;
    inputs[4] = document.getElementById('password').value;
    inputs[5] = document.getElementById('confirm').value;

    var errors = new Array();
    errors[0] = "<span style='color:red'>Please enter your first name!</span>";
    errors[1] = "<span style='color:red'>Please enter your last name!</span>";
    errors[2] = "<span style='color:red'>Please enter your email!</span>";
    errors[3] = "<span style='color:red'>Please enter your user id!</span>";
    errors[4] = "<span style='color:red'>Please enter your password!</span>";
    errors[5] = "<span style='color:red'>Please confirm your password!</span>";

    for (i in inputs) {
        var errMessage = errors[i];
        var div = divs[i];
        if (inputs[i] == "")
            document.getElementById(div).innerHTML = errMessage;

        else if (i == 2) {
            var atpos = inputs[i].indexOf("@");
            var dotpos = inputs[i].lastIndexOf(".");
            if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= inputs[i].length)
                document.getElementById('errEmail').innerHTML = "<span style='color: red'>Enter a valid email address!</span>";
            else
                document.getElementById(div).innerHTML = "<span style='color: #12AD2B'>Looks Good!</span>";
        }
        else if (i == 5) {
            var first = document.getElementById('password').value;
            var second = document.getElementById('confirm').value;
            if (second != first)
                document.getElementById('errConfirm').innerHTML = "<span style='color: red'>Your passwords don't match!</span>";
            else
                document.getElementById(div).innerHTML = "<span style='color: #12AD2B'>Looks Good!</span>";
        }
        else
            document.getElementById(div).innerHTML = "<span style='color: #12AD2B'>Looks Good!</span>";
    }
}

function finalValidate() {
    var count = 0;
    for (i = 0; i < 6; i++) {
        var div = divs[i];
        if (document.getElementById(div).innerHTML == "<span style='color: #12AD2B'>Looks Good!</span>")
            count = count + 1;
    }
    if (count == 6)
        document.getElementById("errFinal").innerHTML = "All the data you entered is correct!!!";
}
    </script>
</head>

<body>

	<div align="center">
		<h1>Library Management System</h1>
		<h2>User Registration</h2>
		<form action="/create" method="get">
		<table id="table1">
		
			<tr>
				<td>First Name:</td>
				<td><input type="text" id="first" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errFirst"></div>
				</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" id="last" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errLast"></div>
				</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" id="email" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errEmail"></div>
				</td>
			</tr>
			<tr>
				<td>User Id:</td>
				<td><input type="text" id="uid" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errUid"></div>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="password" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errPassword"></div>
				</td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" id="confirm" onkeyup="validate();" /><br><br></td>
				<td>
					<div id="errConfirm"></div>
				</td>
			</tr>
			<tr>
				<td><input type="Submit" id="create" value="Create Account"
					onclick="validate();finalValidate();" /></td>
				<td>
					<div id="errFinal"></div>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>

</html>