<%@ page language="java" import="util.MyUtil"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>添加单词</title> 
</head>

<link rel="stylesheet" href="/WordBook_war_exploded/CSS/Add.css" type="text/css"/>
<body bgcolor="Aliceblue">
  <form action="/WordBook_war_exploded/AddWordServlet?act=add" method = "post">
  
  <div class ="add">
  
   <table border=3 style="border-collapse:collapse">
    <caption>
     <font size=6 face=华文新魏><b>添加单词</b></font>
    </caption>

<%--      <tr>--%>
<%--      --%>
<%--       <td><b>单词ID</b><font size=4 color="red">*</font></td>--%>
<%--       <td><input type="text" name="wordId"--%>
<%--           value="<%=MyUtil.getStringID() %>"--%>
<%--           style="border-width:1pt;border-style:dashed;border-color:red"--%>
<%--           readonly/></td>--%>
<%--           --%>
<%--      </tr>--%>
      
      <tr>
      
       <td><b>单词</b><font size=4 color="red">*</font></td>
       <td><input type="text" name="word"></td>
       
      </tr>
      
      <tr>
      
       <td><b>单词汉译</b><font size=4 color="red">*</font></td>
       <td><input type="text" name="meaning"></td>
       
      </tr>
      
	  <tr>


        <td align="center"><input type="reset" value="重置" /></td>
		<td align="center"><input type="submit" value="提交" /></td>
				
		</tr>
 
     </table>
     
     </div>
     
   </form>
</body>
</html>