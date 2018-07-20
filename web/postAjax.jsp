<%--
  Created by IntelliJ IDEA.
  User: Wangchuncheng
  Date: 2018/7/19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>
        window.onload = function () {
            document.getElementsByTagName("button")[0].onclick = function () {
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/static/helloAjax.txt");
                //post方式需要在发送之前设置请求头
                xhr.setRequestHeader("ContentType","application/x-www-form-urlencoded")
                xhr.send("name='wcc'");
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200 || xhr.status == 304) {
                            alert(xhr.responseText);
                        }
                    }
                }
                return false;
            }
        }
    </script>
</head>
<body>
<button>Hello</button>
</body>
</html>
