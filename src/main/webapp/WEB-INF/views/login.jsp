<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
  <head>
	<link href="../css/log-reg.css" rel="stylesheet" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login</title>
	<c:if test="${sessionScope.role != null}">
		<script language="JavaScript">
			window.location.href = "/user-profile"
		</script>
	</c:if>
  </head>
  <body onload='document.loginForm.username.focus();'>
    <header class="header">
	  <div class="user-menu">
	    <nav class="menu">
		  <ul>
		    <li>
			  <a href="/">Back</a>
		    </li>
		  </ul>
	    </nav>
	  </div>
    </header>
    <main>
	  <h1 class="auth-title">Authorization</h1>
		<div class="auth" id="login-box">
		  <c:if test="${not empty error}">
			<div class="error">${error}</div>
		  </c:if>
		  <c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		  </c:if>
		  <c:if test="${sessionScope.name == null}">
			<form name='loginForm' action="<c:url value='/login' />" method='POST'>
			  <table class="auth-table">
				<tr>
					<td>User</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='password' /></td>
				</tr>
			  </table>
			  <input type="hidden" name="${_csrf.parameterName}"
				   value="${_csrf.token}" />
			  <input class="submit-button" name="submit" type="submit"
					 value="Sign in" />
			</form>
		  </c:if>
		</div>
	</main>
  </body>
</html>