<%--
  Created by IntelliJ IDEA.
  User: WLO
  Date: 2024/5/28
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询全部</title>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
    <script>
        function confirmLogout(event) {
            event.preventDefault();

            var userConfirmed = confirm("您确定要注销吗？注销后将无法使用该账号登录！");

            if (userConfirmed) {
                window.location.href = event.currentTarget.href;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1 class="title">今日水果</h1>
    <div class="button-container">
        <a href="insert.jsp" class="button">添加</a>
        <a href="selectAll" class="button">查询</a>
        <a href="update1.jsp" class="button">修改</a>
        <a href="delete.jsp" class="button">删除</a>
        <a href="deleteuserservlet" class="button" onclick="confirmLogout(event)">注销</a>
        <a href="shopfruitservlet" class="button">购物车</a>
    </div>
    <table border="1" class="styled-table">
        <thead>
        <tr>
            <th>名称</th>
            <th>价格</th>
            <th>重量</th>
            <th>产地</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${f}" var="f" varStatus="e">
            <tr class="${e.count % 2 == 0 ? 'even-row' : 'odd-row'}">
                <td>${f.name}</td>
                <td>${f.price}</td>
                <td>${f.weight}</td>
                <td>${f.locations}</td>
                <td class="button-container">
                    <a href="shopfruitinsert?id=${f.id}" class="button">加入购物车</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
