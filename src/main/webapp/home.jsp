<%@ page import="com.bridgelabz.greetingapp.model.Greeting" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 28/7/20
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Greeting> greetings = new ArrayList<>();
        greetings = (List<Greeting>)session.getAttribute("greetings");
        for (Greeting greeting: greetings) {
            System.out.println(greeting.greetingId + " " + greeting.greetingMessage);
        }
    %>
</body>
</html>
