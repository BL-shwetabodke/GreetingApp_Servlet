<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<%
    List<Greeting> greetingList = (List<Greeting>)session.getAttribute("greetings");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%=greetingList%>

    <c:forEach items="${pageScope.greetingList}" var="greetingMessage" varStatus="greetingCounter">
            Greeting ID: <c:out value="${greetingCounter}"/>
            Greeting Message: <c:out value="${greetingMessage}"/>
    </c:forEach>

</body>
</html>
