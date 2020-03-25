<%@ page import="entity.Register" %><%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/21
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>

<%
    if(session.getAttribute("logname") ==null)
        response.sendRedirect("login.jsp");

    Register register = (Register) request.getAttribute("register");
%>
<%--${requestScope.register.getLogname()}
${requestScope.register.getPassword()}
${requestScope.register.getName()}
${requestScope.register.getTel()}--%>

<FORM ACTION="updateServlet">
    账号:<input type="text" name="logname" value="<%=register.getLogname() %>" readonly="readonly"/><br>
    密码：<input type="text" name="password" value="<%=register.getPassword() %>" /><br>
    姓名：<input type="text" name="name" value="<%=register.getName() %>" /><br>
    电话：<input type="text" name="tel" value="<%=register.getTel() %>" /><br>
    <input type="submit" value="修改">
</FORM>

<a href="success.jsp">返回</a>

</body>
</html>
