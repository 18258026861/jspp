<%--
  Created by IntelliJ IDEA.
  User: Barcelona
  Date: 2020/3/24
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mobile</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
<script type="text/html">
    //js的ajax
    function register() {
        var mobile = document.getElementById("mobile").valueOf();
        //通过ajax异步方式请求服务器
        //不用var表示全局变量，负责只能作用域内生效
        xmlHttpRequset = new XMLHttpRequest();

        //设置xmlHttpRequset回调函数
        xmlHttpRequset.onreadystatechange = callBcak;

        //异步open(方法名（提交方法get、post），服务器地址，true)
        //xmlHttpRequset.open("post","MobileServlet",true);
        xmlHttpRequset.open("get","MobileServlet?mobile="+mobile,true);
        /* 设置头信息:setRequestHeader(header,value):
        get:不需要设置此方法
        post：需要设置  1，如果请求包含 文件上传setRequestHeader("Content-Type","multipart/form-data")
                        2.不包含文件上传setRequestHeader("Content-Type","application/x-www-form-urlencoded")
        */
        //xmlHttpRequset.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
       // xmlHttpRequset.send("mobile="+mobile);//发送,方式为key=value
        xmlHttpRequset.send(null);//get方式时，k-v放在open内，send为null


    }

    //回调函数：接收服务端的返回值
    function callBcak() {
        //只在成功的情况下接收
        if (xmlHttpRequset.readyState == 4 && xmlHttpRequset.status == 200) {
            var text = xmlHttpRequset.responseText;
            var x = xmlHttpRequset.responseXML;
        if (text == "true") {
            alert("此账号已存在")
        } else {
            alert("注册成功")
        }
    }
    }
</script>
<script>
    //jq的ajax
    function register(){
        var $mobile = $('#mobile').val();
        /*$.ajax({
            //url：服务器地址
            url:"MobileServlet",
            //请求方式：post，get
            请求方式:"post",
            //data：请求数据
            data : "mobile="+$mobile,
            success:function(result,testStatus) {
                if(result == "true"){
                    alert("已存在");
                }else{
                    alert("注册成功")
                }
            },
            fail:function (xhr,errorMessage,e) {
                    alert("系统异常")
            }
        });*/

        /*$.post(
            "MobileServlet",
            "mobile="+$mobile,
            function (result) {
                if(result == "true"){
                    alert("已存在");
                }else{
                    alert("艹")
                }
            },"text"
        );*/

        //直接将返回值结果输出到id=tip的span里
       /* $("#tip").load(
            "MobileServlet",
            "mobile="+$mobile

        );*/

       $.getJSON(
           "MobileServlet",
           {"mobile":$mobile},
           function (result) {
               if(result == "true"){
                   alert("已存在");
               }else{
                   alert("注册成功")
               }
           },"text"
       )

    }
</script>
    手机型号:<input id="mobile"/>
    <br>
<input type="button" value="提交" onclick="register()"/>
<span id="tip">
</body>
</html>
