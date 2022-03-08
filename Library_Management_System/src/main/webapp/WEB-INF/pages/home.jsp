<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-Management-System</title>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}
body {
	background-color: grey;
	background-image:
		url("https://images.unsplash.com/photo-1481627834876-b7833e8f5570?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bGlicmFyeXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
}

.anchor1 {
	background-color: white;
	border: 2px solid #42f4ce;
	border-radius: 5px;
	color: black;
	padding: 10px;
	text-decoration: none;
}

.anchor1:hover{
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

.anchor2:hover{
	background-color: #42f4ce;
	color: red;
}

.anchor3 {
	background-color: white;
	border: 2px solid #ead2f2;
	border-radius: 5px;
	color: black;
	padding: 10px;
	text-decoration: none;
}

.anchor3:hover{
	background-color: #42f4ce;
	color: red;
}

</style>
<script type="text/javascript">
/**
 * 
 */
function bookname(){
        var str='<form action="/LibraryManagement/showbookbyname" method="get"><input name="book_name" type="text" id="book_name "/><input type="Submit" value="Search"/></form>';
        document.getElementById("bk").innerHTML=str;
      }
function author(){
       var str='<form action="/LibraryManagement/showbookbyauthor" method="get"><input name="author_name" type="text" id="author_name"/><input type="Submit" value="Search"/></form>';
        document.getElementById("au").innerHTML=str;
      }
function category(){
       var str='<form action="/LibraryManagement/showbookbycategory" method="get"><input name="category" type="text" id="category"/><input type="Submit" value="Search"/></form>';
        document.getElementById("cat").innerHTML=str;
      }</script>
     
<body>
 <div align="center">
   
    <h1 style="color:red;">LIBRARY MANAGEMENT SYSTEM</h1><br/><br/> 
    <input class="anchor1" type="button" value="Search By Book Name" onclick="bookname()"/>
    <br><br>
    <div id="bk"></div>
    <br/><br/>
    <input class="anchor2" type="button" value="Search By Author" onclick="author()"/>
    <br><br>
    <div id="au"></div>
    <br/><br/>
    <input class="anchor3" type="button" value="Search By Category" onclick="category()"/>
    <br><br>
    <div id="cat"></div>
    <br/><br/>  
    
    <h4 style="color:white;">
			 Below is the Link to Logout <br><a style="color:green;" href="/LibraryManagement/">Click Me To Logout</a>
		</h4>
    </div>
    


</body>
</head>
</html>