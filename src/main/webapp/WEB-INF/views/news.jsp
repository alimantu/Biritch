<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>News</title>
	<c:if test="${sessionScope.role != null}">
		<script language="JavaScript">
			window.location.href = "/user-profile"
		</script>
	</c:if>
</head>
<body>

	<h1>News page!</h1>

	<a href="/login">Sign in</a><br>
	<a href="/registration">Sign up</a><br>

</body>
</html>