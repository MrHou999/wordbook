<%@ page language="java" import="util.MyUtil"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除单词</title>
</head>
<body bgcolor="Aliceblue">
  <script type="text/javascript" charset="UTF-8" src="/WordBook_war_exploded/Interface/checkDel.js"></script>
   <form action="/WordBook_war_exploded/DeleteWordServlet" name="deleteForm">
   
      <table border="3" bordercolor="Aliceblue">
      
        <tr>
        
          <th width="350px"><b>单词ID</b></th>
          <th width="300px"><b>单词</b></th>
          <th width="300px"><b>单词汉译</b></th>
          <th width="300px"><b>操作</b></th>
        </tr>
        
        
                <c:forEach var="g" items="${requestScope.AllWords }">
        
          <tr align="center">
          
             <td align="left">
            
               <input type="checkbox" name="wordId" value="${g.wordid}">
              ${g.wordid } 
               
             </td>
             
             <td>${g.word }</td>
             <td>${g.meaning }</td>
             
             <td align="center">
             
               <a href="javascript:checkDel('${g.wordid }')"><b>删除</b></a>
               
             </td>
             
          </tr>
          
        </c:forEach>
        
        
        <tr>
        
         <td colspan="6" align="center">
         
         <input type="hidden" name="act" value="button">
         <input type="button" value="删除" onclick="confirmDelete()">
         
         </td>
         
        </tr>
        
      </table>
      
   </form>
   
</body>
</html>