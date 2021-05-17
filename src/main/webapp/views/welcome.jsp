<%@ page import="com.example.lab10_JSP.DB" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10_JSP.Channel" %><%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.05.2021
  Time: 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        ArrayList<Channel> channels = DB.getChannels(response.getWriter());
        PrintWriter pw = response.getWriter();
        for(Channel c : channels) {
            pw.println("<p>Channel: " + c.channel +
                    "; owner: " + c.owner + "<br>");
        }
    %>
    <jsp:include page="header"></jsp:include><br>
    <label>New Chanel</label>
    <form name="login" method="post" action="newchanelServlet" style="margin: 5px 5px 5px 0px;">
        Channel: <input type="text" name="channel" style="margin: 5px;"><br>
        Owner: <input type="text" name="owner" style="margin: 5px;"><br>
        <input type="submit" value="добавить" style="margin: 5px;">
    </form><br>
    <jsp:include page="footer"></jsp:include>
</body>
</html>
