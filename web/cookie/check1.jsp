<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check</title>
</head>
<body>
        <%
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            //将用户名加入cookie
            Cookie cookie1 = new Cookie("name",name);
            cookie1.setMaxAge(10);//最大有效期10秒
            //Cookie cookie2 = new Cookie("password",password);
            response.addCookie(cookie1);
            response.sendRedirect("result.jsp");

        %>
</body>
</html>
