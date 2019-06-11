<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
		学生信息<br>
		<a href="stuadd.jsp">添加学生</a>
<table  border=1 >
<tr>
   <td>学号</td>
  <td>姓名</td>
  <td>操作</td>
  </tr>
 <s:iterator value="#request.students"  var="student">
						 	<tr align="center">
						 	     <td>${student.userid}</td>
								<td>${student.username}</td>
								  <td align="center"><a href="stuedit.jsp?id=${student.userid}">修改</a>
								  <a href="${pageContext.request.contextPath}/delete.action?stId=${student.userid}">删除</a></td>
								
					 		</tr>
			  			</s:iterator>			  			
</table>
		<a href="main.jsp">返回</a>
	</center>
</body>
</html>