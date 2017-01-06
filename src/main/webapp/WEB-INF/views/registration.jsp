<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
  <head>
    <link href="../css/log-reg.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Registration</title>
    <c:if test="${sessionScope.role != null}">
        <script language="JavaScript">
            window.location.href = "/user-profile"
        </script>
    </c:if>
  </head>
  <body onload='document.regForm.username.focus();'>
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
      <h1 class="reg-title">Registration</h1>
      <div class="reg">
        <form:form modelAttribute="user" name="regForm" method="POST" id="form" enctype="utf8">
          <table class="reg-table">
            <tr>
              <td><label>Login</label></td>
              <td><form:input path="username" value=""/></td>
              <tr><td></td>
                <td>
                  <div class="error-mes"><form:errors path="username" element="div"/></div>
                </td>
              </tr>
            </tr><br>
            <tr>
              <td><label>Email</label></td>
              <td><form:input path="email" value="" /></td>
              <tr><td></td>
                <td>
                  <div class="error-mes"><form:errors path="email" element="div"/></div>
                </td>
              </tr>
            </tr><br>
            <tr>
              <td><label>Password</label></td>
              <td><form:input path="password" value="" type="password" /></td>
              <tr><td></td>
                <td>
                  <div class="error-mes"><form:errors path="password" element="div" /></div>
                </td>
              </tr>
            </tr><br>
            <tr>
              <td><label>Confirm the password</label></td>
              <td><form:input path="matchingPassword" value="" type="password" /></td>
              <tr><td></td>
                <td>
                  <div class="error-mes"><form:errors element="div" /></div>
                </td>
              </tr>
            </tr><br>
          </table>
          <input class="submit-button-reg" name="submit" type="submit"
                 value="Sign up" />
        </form:form>
      </div>
    </main>
  </body>
</html>
