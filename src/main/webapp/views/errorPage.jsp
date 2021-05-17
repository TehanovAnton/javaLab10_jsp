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
    <%
        HttpSession sess = ((HttpServletRequest)request).getSession();
        String er = (String) session.getAttribute("error");
        er = er == null ? "..." : er;

        Cookie cookie = new Cookie("logged", "true");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    %>
    <p><%=er%></p><br>
    <a href="login">back to login</a>
</body>
</html>
