<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新单词</title>
</head>
<body bgcolor="Aliceblue">

   <form action="/WordBook_war_exploded/AddWordServlet?act=updateSelect">
   
      <table border="3" bordercolor="black">
      
        <tr>
        
          <th width="250px"><b>单词ID</b></th>
          <th width="250px"><b>单词</b></th>
          <th width="250px"><b>单词汉译</b></th>
          <th width="250px"><b>操作类型</b></th>
          
        </tr>
        
        <c:forEach var="g" items="${requestScope.AllWords }">
        
          <tr align="center">
          
             <td>${g.wordid }</td>
             <td>${g.word }</td>
             <td>${g.meaning }</td>
             <td>
             
               <a href="/WordBook_war_exploded/SelectDetailServlet?wordId=${ g.wordid }&act=updateAWord"><b>修改</b></a>
               
             </td>
             
          </tr>
          
        </c:forEach>

      </table>
      
   </form>
   
</body>
</html>