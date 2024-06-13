<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
    <script>
        // 设置3秒后跳转到登录页面
        setTimeout(function() {
            window.location.href = 'login.jsp';
        }, 3000); // 3000毫秒，即3秒
    </script>
</head>
<body>
<div class="container">
    <h1>注册成功</h1>
    <p>${successMessage}</p>
    <p>页面将在 <span id="countdown">3</span> 秒后跳转到登录页面。</p>
</div>

<script>
    var countdownElement = document.getElementById('countdown');
    var countdown = 3;
    setInterval(function() {
        countdown--;
        if (countdown >= 0) {
            countdownElement.textContent = countdown;
        }
    }, 1000);
</script>
</body>
</html>
