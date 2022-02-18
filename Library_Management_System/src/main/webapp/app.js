/**
 * 
 */
 function bookname(){
        var str='<form action="Search" method="get"><input name="book_name" type="text" id="book_name "/><input type="Submit" value="Search"/></form>';
        document.getElementById("bk").innerHTML=str;
      }
      function author(){
       var str='<form action="Search" method="get"><input name="author_name" type="text" id="author_name"/><input type="Submit" value="Search"/></form>';
        document.getElementById("au").innerHTML=str;
      }
      function category(){
       var str='<form action="Search" method="get"><input name="category" type="text" id="category"/><input type="Submit" value="Search"/></form>';
        document.getElementById("cat").innerHTML=str;
      }