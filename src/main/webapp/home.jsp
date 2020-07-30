<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:scriptlet>

        List greetingList = (List)session.getAttribute("greetings");
        pageContext.setAttribute("greetingList", greetingList);

</jsp:scriptlet>
<html>
<head>
    <title>Greeting App</title>
    <style>
        table {
            border: 1px solid black;
        }
        table{
            width: 25%;
        }
        tr {
            display: flex;
            justify-content: space-around;
        }
    </style>
</head>
<body>
<table>
    <th>Sr. No.</th>
    <th>Greeting Message</th>
</table>
<c:forEach items="${pageScope.greetingList}" var="greetingMessage" varStatus="greetingCounter">
    <table >
        <td><c:out value="${greetingCounter.count}"/></td>
        <td><c:out value="${greetingMessage}"/></td>
    </table>
</c:forEach>
</body>
</html>
