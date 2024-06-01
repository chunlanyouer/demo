<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
    <script type="text/javascript">
        function validateForm() {
            const checkbox = document.getElementById("agreement");
            if (!checkbox.checked) {
                alert("请阅读并同意用户协议");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h1 class="title">登录</h1>
    <form method="post" action="LoginServlet" onsubmit="return validateForm();">
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="error-message"><%= errorMessage %></div>
        <% } %>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>

        <div class="agreement-container">
            <input type="checkbox" id="agreement" name="agreement" required>
            <label for="agreement">我已阅读并同意 <a href="http://www.baidu.com" target="_blank">用户协议</a></label>
        </div>

        <div class="button-container">
            <input type="submit" value="登录" class="button">
            <a href="register.jsp" class="button button-secondary">注册</a>
        </div>
    </form>
</div>
</body>
</html>
