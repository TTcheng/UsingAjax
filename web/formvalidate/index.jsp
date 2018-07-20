<%--
  Created by IntelliJ IDEA.
  User: Wangchuncheng
  Date: 2018/7/20
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>formvalidate</title>
    <%--jquery library--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
        var baseUrl = "${pageContext.request.contextPath}/formvalidate/";
        $(function () {
            $(":input[name='username']").change(function () {
                var username = $(this).val();
                username = $.trim(username);
                if (username == "") {
                    $('#message').html("<font color='red'>用户名不能为空</font>");
                } else {
                    //向服务器请求，服务器返回用户名是否可用，如<font color='red'>用户名不可用</font>
                    $.post(baseUrl + "validateUsername", {"username": username}, function (data) {
                        $('#message').html(data);//将服务器返回的信息，打印在<div id="message"></div>内
                    });
                }
            });
        })
    </script>
</head>
<body>
<form action="" method="post">
    UserName:<input id="user-name-label" type="text" name="username"/>
    <br><br>
    <div id="message"></div>
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
