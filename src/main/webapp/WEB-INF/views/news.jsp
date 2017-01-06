<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
	<link href="../css/main-page.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>News</title>
    <c:if test="${sessionScope.role != null}">
	  <script language="JavaScript">
	    window.location.href = "/user-profile"
	  </script>
    </c:if>
  </head>
  <body>
    <footer>
	  <div class="user-menu">
		<nav class="menu">
		  <ul>
			<li class="li-first">
			  <a href="/login">Sign in</a>
			</li>
			<li class="li-second">
			  <a href="/registration">Sign up</a>
			</li>
		  </ul>
		</nav>
	  </div>
    </footer>
    <main>

    </main>

  </body>
</html>