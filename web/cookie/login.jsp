<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        String cname;//定义全局变量
    %>
    <%
        //先获取cookie，然后遍历是否曾经输入的用户名，如果有，就把值赋给用户名默认值
        boolean flag = false;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("name")){
                cname = cookie.getValue();
                flag = true;
            }
        }
        if(!flag){//10秒后会失效
            out.println("cookie失效");
        }else
            out.println("cookie："+cname);

    %>
    <form action="check1.jsp">
        用户名:<input type="text" name="name" value="<%=cname%>"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录"><br>
    </form>
</body>
</html>
