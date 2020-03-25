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
    <title>success</title>
</head>
<body>
<%
    Object name = session.getAttribute("name");
    Object password = session.getAttribute("password");
    //out.println("欢迎  ："+request.getParameter("name"));


    //若果用户没有登录，则session.name=null，就返回登录界面
    if(name != null){//不是"null"
        out.println("欢迎  ："+name);
        out.println("欢迎  ："+password);
    }else{
        response.sendRedirect("login.jsp");
    }

%>
<a href="invalidate.jsp">注销</a>
<a href="show.jsp">查看</a>

</body>
</html>
