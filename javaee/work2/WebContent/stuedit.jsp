<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <center>
    <form method="post" action="stuedit">
        学号：<input type="text"  name="id"  value="<%=request.getParameter("id")%>"/><br />
        姓名：<input type="text" name="username" /><br />
        <input type="submit" value="提交"/>
    </form>
    </center>
  </body>
</html>
