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
    <title>修改水果信息</title>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
<div class="container">
    <h1 class="title">修改水果信息</h1>
    <table border="1" class="styled-table">
        <div class="button-container">
            <a href="selectAll" class="button">查询</a>
        </div>
        <thead>
        <tr>
            <th>ID</th>
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
                <td>${f.id}</td>
                <td>${f.name}</td>
                <td>${f.price}</td>
                <td>${f.weight}</td>
                <td>${f.locations}</td>
                <td>
                    <a href="selectById?id=${f.id}" class="action-link">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
