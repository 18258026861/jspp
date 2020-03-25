<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/23
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.*" %>
<%@ page import="listener.BeanListener2" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BeanListener2 bean = new BeanListener2();
    bean.setName("YY");
    bean.setId(1);
    session.setAttribute("bean",bean);
%>
</body>
</html>
