<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.05.2021
  Time: 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <label>Вход в систему</label>
    <form name="login" method="post" action="welcome" style="margin: 5px 5px 5px 0px;">
        <input type="text" name="username" content="Username" style="margin: 5px;"><br>
        <input type="text" name="password" content="Password" style="margin: 5px;"><br>
        <input type="submit" value="войти" style="margin: 5px;">
        <a href="register">регистрация</a>
    </form>
</body>
</html>
