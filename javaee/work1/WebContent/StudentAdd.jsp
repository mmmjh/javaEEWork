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
	学生添加<br>
	<form action="AddStudent?method=add" method="post">
		<table border=1>
			<tr>
				<td>学号</td>
				<td><input type="text" id ="ID" name="ID"></input></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" id = "username" name="username"></input></td>
			</tr>
		</table>
		<button type="submit">提交</button>
	</form>
	</center>
</body>

</html>