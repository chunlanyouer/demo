<%--
  Created by IntelliJ IDEA.
  User: WLO
  Date: 2024/5/31
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
<div class="container">
    <h1 class="title">注册</h1>

    <!-- 显示错误信息 -->
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <form method="post" action="RegisterServlet">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirmPassword">确认密码:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <label for="phone">手机号:</label>
        <input type="text" id="phone" name="phone" required>

        <div class="button-container">
            <input type="submit" value="注册" class="button">
            <a href="login.jsp" class="button button-secondary">登录</a>
        </div>
    </form>
</div>
</body>
</html>
