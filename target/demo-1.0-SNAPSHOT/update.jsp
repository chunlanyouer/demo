<%--
  Created by IntelliJ IDEA.
  User: WLO
  Date: 2024/5/28
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
<div class="container">
    <h1 class="title">修改水果信息</h1>
    <form action="update" method="post">
        <table class="styled-table">
            <input type="hidden" name="id" value="${f.id}">
            <tr>
                <td>名称</td>
                <td><input type="text" name="name" value="${f.name}" required></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="number" name="price" value="${f.price}" required></td>
            </tr>
            <tr>
                <td>重量</td>
                <td><input type="number" name="weight" value="${f.weight}" required></td>
            </tr>
            <tr>
                <td>产地</td>
                <td><input type="text" name="locations" value="${f.locations}" required></td>
            </tr>
            <tr>
                <td colspan="2" class="button-container">
                    <input type="submit" value="修改" class="button">
                    <input type="reset" value="回退" class="button reset-button" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
