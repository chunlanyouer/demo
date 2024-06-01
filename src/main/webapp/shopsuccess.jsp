<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买成功</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
    <script>

        setTimeout(function() {
            window.location.href = 'selectAll';
        }, 3000);
    </script>
</head>
<body>
<div class="container">
    <h1>购买成功</h1>
    <p>${successMessage}</p>
    <p>页面将在 <span id="countdown">3</span> 秒后跳转到今日水果页</p>
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
