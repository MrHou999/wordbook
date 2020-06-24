<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interface</title>
<link rel="stylesheet" href="/WordBook_war_exploded/CSS/BackgroundCSS.css" type="text/css"/>
</head>
<body>

   <div id="header">
   
     <br>
       <h1>欢迎进入单词管理系统</h1>
   </div>
   
   <div class="navigator">
   
     <ul>
     
       <li><a href="/WordBook_war_exploded/SelectWordsServlet?act=select" target="center">查询单词</a></li>
       <li><a href="/WordBook_war_exploded/Manager/AddWord.jsp" target="center">添加单词</a></li>
       <li><a href="/WordBook_war_exploded/SelectWordsServlet?act=updateSelect" target="center">修改单词</a></li>
       <li><a href="/WordBook_war_exploded/SelectWordsServlet?act=deleteSelect" target="center">删除单词</a></li>
    
     </ul>
     
   </div>
   
   <div id="content">
   
     <iframe src="/WordBook_war_exploded/SelectWordsServlet?act=select" name="center" frameborder="0" width="980" height="500" scrolling="yes" marginheight="100"></iframe>
   
   </div>
   
   <div id="footer"><h3>Copyright2020@系统版权归RaySunWHUT所有</h3></div>
   
</body>
</html>