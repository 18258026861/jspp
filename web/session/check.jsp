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


            if(name.equals("yy") ){//只有登录成功，session中才会保存账户密码
                //添加session属性
                session.setAttribute("name",name);
                session.setAttribute("password",password);
                session.setMaxInactiveInterval(10);//设置非活动时间，秒

                //添加cookie属性
                //如果不添加，服务端也会是自动生成一个name = JESSIONID的cookie
                Cookie cookie1 = new Cookie("name",name);
                Cookie cookie2 = new Cookie("name",name);
                response.addCookie(cookie1);
                response.addCookie(cookie2);

                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                response.sendRedirect("login.jsp");
            }
        %>
</body>
</html>
