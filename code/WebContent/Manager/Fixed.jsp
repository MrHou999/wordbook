<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Come Back</title>
</head>
<body>

    <h1>
    
    <font color = "black">
    <b>
    
    You control failed! After 4 seconds , you will come back to the main Interface!
    
    </b>
    </font>
    
    </h1>
             
   <% response.setHeader("refresh", "4; url=Manager/AddWord.jsp"); %>
   
</body>
</html>