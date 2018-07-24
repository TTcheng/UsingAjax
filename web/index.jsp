<%--
  Created by IntelliJ IDEA.
  User: Wangchuncheng
  Date: 2018/7/19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>
        window.onload = function () {
            //1、找到元素a
            var e = document.getElementsByTagName("button")[0];
            e.onclick = function () {
                //3.创建xhr对象
                var xhr = new XMLHttpRequest();
                //4、准备发送数据
                var url = "${pageContext.request.contextPath}/static/helloAjax.txt"+"?time="+new Date();
                var method = "GET";
                //5、xhr.open
                xhr.open(method, url);
                //6、xhr.send
                xhr.send(null);
                //7、xhr对象添加onreadystatechange函数
                xhr.onreadystatechange = function () {
                    //alert(xhr.readyState);
                    //8、判断响应是否完成,readyState=4
                    if (xhr.readyState == 4) {
                        //9、判断响应是否可用,status 200
                        if (xhr.status == 200 || xhr.status == 304) {
                            //10、打印结果responseText
                            alert(xhr.responseText);
                        } else {
                            alert("出错了，错误代码" + xhr.status);
                        }
                    }
                }
                //2、取消默认行为
                return false;
            }
        }
    </script>
</head>
<body>
<button>Hello</button>
</body>
</html>
