<%--
  Created by IntelliJ IDEA.
  User: Wangchuncheng
  Date: 2018/7/19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $('a').click(function () {
                var url = this.href+" h2 a";//只显示he元素下a元素的内容
                var args = {"time":new Date()};
                //使用load方法处理ajax
                $('#content').load(url,args);
                return false;
            });
        });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/static/ajaxhtml/files/andy.html">andy</a>
<h2 id="content"></h2>
</body>
</html>
