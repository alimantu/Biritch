<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link href="../css/user-service.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>403</title>
  </head>
  <body>
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
	  <c:when test="${empty username}">
		<h2>You do not have permission to access this page!</h2>
	  </c:when>
	  <c:otherwise>
		<h2>Username : ${username} <br/>
			You do not have permission to access this page!</h2>
	  </c:otherwise>
	</c:choose>

  </body>
</html>