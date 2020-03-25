<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlet.showallServlet" %>
<%@ page import="entity.Bean" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<%
    if(session.getAttribute("logname") ==null)
        response.sendRedirect("login.jsp");
    out.println("欢迎  ："+session.getAttribute("logname"));
    Bean bean = new Bean();
    session.setAttribute("bean",bean);
%>
<a href="showallServlet?logname=<%=session.getAttribute("logname")%>">查询</a>
<a href="exitServlet">注销</a>




<br>${3>2}
<br>${sessionScope.logname}
<br>${empty sessionScope.gg}<%--不存在的为true--%>
<br>${param.logname}<%--获取表单数据--%>
<br>${pageContext.session}<%--通过pageContext获取jsp的隐式对象
--%>
<br>
</body>
</html>
