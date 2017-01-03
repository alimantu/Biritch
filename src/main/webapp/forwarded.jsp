<%--
  Created by IntelliJ IDEA.
  User: Alimantu
  Date: 03/09/16
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="body/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forwarded Page</title>
</head>
<body>
    <h1>Nice forward</h1>
    <form action="test" method="POST">
        <c:forEach var="par" items="${variant}">
            <input type="checkbox" name="label" value="${par}">${par}<br>
        </c:forEach>
    </form>
</body>
</html>
