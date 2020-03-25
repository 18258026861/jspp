<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <%
      Cookie[] cookies = request.getCookies();
      for(Cookie cook : cookies){
          out.println(cook.getName()+","+cook.getValue());
      }
    %>
</body>
</html>
