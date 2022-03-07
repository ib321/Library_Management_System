<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Library-Management-System</title>
    <link rel="stylesheet" type="text/css" href="input1.css">
    <script type="text/javascript" src="app.js"></script>
</head>
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
    
    <h4>
			For Check Purpose Will be Removed Later<a href="showbookbyname">here</a>
		</h4>
    </div>
    
</body>
</html>