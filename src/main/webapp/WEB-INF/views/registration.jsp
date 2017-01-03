<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Registration</title>
    <c:if test="${sessionScope.role != null}">
        <script language="JavaScript">
            window.location.href = "/user-profile"
        </script>
    </c:if>
</head>
<body>
    <h1>Sign up</h1>
    <form:form modelAttribute="user" method="POST" id="form" enctype="utf8">
        <tr>
            <td><label>Login</label></td>
            <td><form:input path="username" value="" /></td>
            <form:errors path="username" element="div"/>
        </tr><br>
        <tr>
            <td><label>Email</label></td>
            <td><form:input path="email" value="" /></td>
            <form:errors path="email" element="div"/>
        </tr><br>
        <tr>
            <td><label>Password</label></td>
            <td><form:input path="password" value="" type="password" /></td>
            <form:errors path="password" element="div" />
        </tr><br>
        <tr>
            <td><label>Confirm the password</label></td>
            <td><form:input path="matchingPassword" value="" type="password" /></td>
            <form:errors element="div" />
        </tr><br>
        <button type="submit" name="submit">Sign up</button>
    </form:form>

</body>
</html>
