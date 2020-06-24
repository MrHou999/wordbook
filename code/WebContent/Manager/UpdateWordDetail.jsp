<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Goods in DataBase</title>
</head>
<link rel="stylesheet" href="/WordBook_war_exploded/CSS/UpdateDetail.css" type="text/css"/>
<body bgcolor="Aliceblue">

<script type="text/javascript" charset="UTF-8" src="/WordBook_war_exploded/Interface/checkDel.js"></script>

    <form action="/WordBook_war_exploded/AddWordServlet?act=updateSelect" method="post">
    
    <div class = "update">
    
   <table border=2 style="border-collapse:collapse">
   
    <caption>
    
     <font size=6 face=华文新魏><b>修改单词</b></font>
     
    </caption>
    
      <tr>
      
       <td><b><font size=4 color="black">单词ID</font></b><font size=3 color="red">*</font></td>
       <td>${ requestScope.AWord.wordid }<input type="hidden" name="wordId" value="${ requestScope.AWord.wordid }"></td>
           
      </tr>
      
      <tr>
      
       <td><b><font size=4 color="black">单词</font></b><font size=3 color="red">*</font></td>
       <td><input type="text" name="word" value="${ requestScope.AWord.word }"/></td>
       
      </tr>
      
      <tr>
      
       <td><b><font size=4 color="black">单词汉译</font></b><font size=3 color="red">*</font></td>
       <td><input type="text" name="meaning" value="${requestScope.AWord.meaning}"></td>
       
      </tr>
      
       <tr>
       
       <td align="center"><input type="submit" value="修改"></td>
       <td align="center"><button type="button" onclick="cancel()">取消</button></td>
       
       </tr>
       
   </table>
   
   </div>
   
   </form>
   
</body>
</html>