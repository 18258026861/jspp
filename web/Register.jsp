<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/20
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlet.RegisterServlet" %>

<html>
<head>
    <title>register</title>
</head>
<body>
<form action="RegisterServlet">
    账号:<input type="text" name = "logname">
    密码：<input type="text" name = "password">
    姓名:<input type="text" name = "name">
    电话：<input type="text" nmae = "tel">
    <input type="submit" value="注册">
</form>
</body>
</html>
