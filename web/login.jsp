<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/17
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="servlet.*" %>
<html>
<head>
    <title>登录</title>
</head>
<BODY bgcolor=#006400>
<%--get：在地址栏显示信息，但是容纳的信息有限，可能会出错，所以不能上传文件，不够安全
    post:上传文件
--%>
            <%--<fORM action="show.jsp" Method="post">
                登录名称:<Input type=text name="name"><br>
                输入密码:<Input type=password name="password"><br>
                性别单选框<br>
                <input type="radio" name="sex" checked value="man">男
                <input type="radio" name="sex" value="woman">女<br><br>
                爱好多选框<br>
                <input type="checkbox" name="hobby" value="basektball">篮球
                <input type="checkbox"  name="hobby" value="soccer">足球
                <input type="checkbox" name="hobby" value="pingpang">乒乓球
        <Input type=submit name="g" value="show">
        </form>--%>

<%
    String message = (String)request.getAttribute("message");         // 获取错误属性
    if(message != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=message%>");                                            // 弹出错误信息

    /*window.location='login.jsp' ;     */                       // 跳转到登录界面
</script>
<%
    }
%>



<fORM action="LoginServlet" Method="post">
    登录名称:<Input type=text name="logname"><br>
    输入密码:<Input type=password name="password"><br>
    <Input type=submit name="g" value="check">
</form><br><br>
<fORM action="register.jsp" Method="post">
    <Input type=submit name="g" value="check">
</form>
</div >

</BODY></HTML>
