<%--
  Created by IntelliJ IDEA.
  User: FH
  Date: 11/5/2023
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.service123.tiketing.model.entity.User" %>
<%@ page import="com.service123.tiketing.model.service.UserService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="assets/Designation/css/style2.css">
  <title>داشبورد کاربری تیکت</title>
  <link rel="stylesheet" href="style2.css">
  <link rel="stylesheet" href="assets/css/style.css">

</head>
<body>
<div class="top">
  <h1>صفحه تخصیص پیام </h1>
</div>

<div class="content-container">
  <div class="image-container">
    <img src="image1.jpg" alt="تصویر شماره1" style="float:left;width:500px;height:300px;">
  </div>

  <div class="form-container">
    <div class="myform">
      <h2>توضیحات کاربر</h2>
      <form action="/user.do" method="post">
        <label>
          <p style="font-size:30px;">کاربر شماره1</p>
        </label>
        <p>
        <h2>
          <textarea name="description" placeholder=" متن توضیحات کاربر" rows="10"></textarea>
        </h2>
        </p>

        <textarea name="description" placeholder="متن توضیحات کارشناس" rows="10"></textarea>
        <input type="submit" value="ثبت">
      </form>
    </div>
  </div>
</div>

<table>
  <thead>
  <tr>
    <th>User Role</th>
    <th>ID</th>
    <th>UserName</th>
    <th>Name</th>
    <th>Family</th>
  </tr>
  </thead>
  <tbody>
  <% for (User user : UserService.getService().findAll()) { %>
  <tr>
    <td><%= user.getUserRoles() %></td>
    <td><%= user.getId() %></td>
    <td><%= user.getUserName() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getFamily() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<script src="assets/js/js.js"></script>
</body>
</html>
