<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<h2>${pageContext.request.getAttribute("SPRING_SECURITY_403_EXCEPTION").getMessage()}</h2>
<h2>${pageContext.request.getAttribute("SPRING_SECURITY_403_EXCEPTION")}</h2>
</body>
</html>
