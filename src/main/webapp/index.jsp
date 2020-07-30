<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Get Text Input Field Value in JavaScript</title>
</head>
<body>
<jsp:scriptlet>
    List greetingList = (List) session.getAttribute("greetings");
    pageContext.setAttribute("greetingList", greetingList);
    </jsp:scriptlet>
<div class="main">
<form method="post" action="/greeting">
    <input class="first" type="text" placeholder="Your's First Name..." id="firstName" name="firstName">
    <input class="last" type="text" placeholder="Your's Last Name..." id="lastname" name="lastname">
    <button class="add" type="submit" onclick="getInputValue()">Add</button>
</form>
</div>

<div class="table-box">

    <div class="table-row table-head">

        <div class="table-cell head-cell">
            <p> SrNo</p>
        </div>
        <div class="table-cell">
            <p>Message</p>
        </div>
        <div class="table-cell">
            <p> Delete</p>
        </div>
    </div>

    <c:forEach items="${pageScope.greetingList}" var="greeting">

        <div class="table-row">

            <div class="table-cell head-cell">
                <p> <c:out value="${greeting.greetingId}"/></p>
            </div>
            <div class="table-cell">
                <p><c:out value="${greeting.greetingMessage}"/></p>
            </div>
            <div class="table-cell last-cell">
            <form action="/greeting/delete">
                <button class="delete" type="submit" name="id" value="${greeting.greetingId}">Delete</button>
            </form>
            </div>
        </div>
    </c:forEach>

</div>
</div>
<style>
    body {
        height: 100%;
        width: 100%;
    }

    div.main {
        margin-top: 5%;
        margin-left: 10%;
    }

    div.table {
        width: fit-content;
        height: fit-content;
    }

    input.first {
        height: 40px;
        margin-right: 2%;
        size: 24px;
        width: max-content;

    }

    input.last {
        height: 40px;
        margin-right: 2%;
        size: 24px;
    }

    button {
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        border-radius: 12px;
    }

    button.add {
        background-color: #4CAF50; /* Green */
    }

    button.edit {
        background-color: #8665f7; /* blue */
        padding: 5% 5%;
        font-size: 13px;
    }

    button.delete {
        background-color: red; /* Red */
        padding: 5% 5%;
        font-size: 13px;
    }

    div.table-box {
        margin: 50px auto;
    }

    div.table-row {
        display: table;
        width: 80%;
        margin: 10px auto;
        font-family: sans-serif;
        background: transparent;
        padding: 12px 0;
        color: #555;
        font-size: 13px;
        box-shadow: 0 1px 4px 0 rgba(0, 0, 50, 0.3);
    }

    div.table-cell {
        display: table-cell;
        width: 20%;
        text-align: center;
        padding: 4px 0;
        border-right: 1px solid #8665f7;
        vertical-align: middle;

    }

    div.table-row.table-head {
        background: #8665f7;
        color: black;
        box-shadow: none;
        font-weight: 600;

    }

    div.table-cell.last-cell {
        display: table-cell;
        width: 20%;
        text-align: center;
        padding: 4px 0;
        border-right: none;
        vertical-align: middle;

    }

    div.table-cell.head-cell {
        display: table-cell;
        width: 10%;
        text-align: center;
        padding: 4px 0;
        border-right: none;
        vertical-align: middle;
    }

</style>

</body>
</html>