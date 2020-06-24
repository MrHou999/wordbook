<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>查询单词</title>
</head>
<link rel="stylesheet" href="/WordBook_war_exploded/CSS/Search.css" type="text/css"/>

<body bgcolor="Aliceblue">

    <form action="/WordBook_war_exploded/SelectWordsServlet" method = "post">
    
    <center><br>
    
       <div class = "search">
     <table>
     
        <tr>
          
       
           <td width="250px">
           
           <b>搜索：</b><input type="text" name="keyword" class = "key">
           
           </td>
           
           <td width="250px">
           
               <input type="hidden" name="act" value="condition"/>
               <input type="submit" value="Go"/>
            
            </td>
         
         
        </tr>        
        
       
     </table>
     
      </div>
     
    <br>
    
    </center>
    
    </form>
    
    <table border="1" bordercolor="Aliceblue">
    
       <tr>
       
         <th width="300px">单词ID</th>
         <th width="300px">单词</th>
         <th width="300px">单词汉译</th>
         
         
       </tr>
       
       
       <c:forEach var="g" items="${requestScope.AllWords }">
       
          <tr align="center">
          
          <td >${g.wordid }</td>
          <td>${g.word }</td>
          <td>${g.meaning }</td>
         
          </tr>

       </c:forEach>
      
    </table>
    
</body>
</html>