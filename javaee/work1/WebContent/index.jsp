  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		学生信息<br>
		<a href="StudentAdd.jsp">添加</a>
		<br>		
		<table border=1>
			<tr>
				<td>学号</td><td>姓名</td><td>操作</td>
			</tr>
	        <c:forEach items="${userBeans}" var="item" varStatus="status">
						<tr>
							<td align="center">${item.userid}</td>
							<td align="center">${item.username}</td>
							<td align="center"><a href="StudentEdit.jsp?method=update&id=${item.userid}">修改</a>
								<a href="DeleteStudent?method=delete&id=${item.userid}">删除</a></td>
						</tr>
			</c:forEach>
		</table>
		<a href="index.jsp">返回</a>
	</center>
</body>

</html>