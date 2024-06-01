<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>倪倪的水果小店</title>
  <link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
<div class="container">
  <h1 class="title"><%= "倪倪的水果小店" %></h1>
  <div class="button-container">
    <a href="login.jsp" class="button" onclick="if (confirm('请先登录')) { window.location.href = 'login.jsp'; } return false;">查看今日水果</a>
  </div>

  <!-- 水果介绍部分 -->
  <div class="fruit-section">
    <h2 class="section-title">水果介绍，欢迎选购</h2>
    <div class="fruit-item">
      <h3 class="fruit-name">苹果</h3>
      <p>苹果是一种非常健康的水果，富含维生素C和膳食纤维，对心脏健康有益。</p>
    </div>
    <div class="fruit-item">
      <h3 class="fruit-name">香蕉</h3>
      <p>香蕉富含钾和维生素B6，有助于维持心脏健康和血压稳定，是一种便捷的能量来源。</p>
    </div>
    <div class="fruit-item">
      <h3 class="fruit-name">橙子</h3>
      <p>橙子含有丰富的维生素C，对免疫系统非常有益，并且有助于肌肤健康。</p>
    </div>
    <div class="fruit-item">
      <h3 class="fruit-name">葡萄</h3>
      <p>葡萄富含抗氧化剂和维生素K，有助于保护心脏健康，促进血液循环。</p>
    </div>
  </div>
</div>
</body>
</html>

