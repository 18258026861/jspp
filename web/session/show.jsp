<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<%
    out.println("session id:<br>"+session.getId());
    out.println("<br>name:<br>"+session.getAttribute("name"));
    out.println("<br>password:<br>"+session.getAttribute("password"));
    Cookie[] cookie = request.getCookies();

    out.println("<br>");
    out.println("<br>");
    out.println("<br>");
    out.println("cookie:");
    for(Cookie c : cookie )
    {
        out.println("<br>value:<br>"+c.getValue());
        out.println("<br>"+c.getPath());
    }
    out.println("<br>");
    out.println("<br>");


    out.print("虚拟路径"+application.getContextPath());
    out.print("绝对路径"+application.getContextPath(/web_learing_war_exploded));
    //application.getRealPath();
%>
<a href="success.jsp">返回</a>
</body>
</html>
