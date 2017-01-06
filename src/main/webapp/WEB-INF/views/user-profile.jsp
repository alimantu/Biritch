<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link href="../css/user-service.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User-profile</title>
    <script>
      function formSubmit() {
        document.getElementById("logoutForm").submit();
      }

      function removeTag(element) {
        var divListTag = document.getElementById(element.parentNode.id);
        divListTag.classList.remove('list-my-tags-block');
        divListTag.classList.add('list-my-tags-none');
      }
    </script>
  </head>
  <body>
    <header class="header">
      <div class="user-menu">
        <div class="container">
          <nav class="menu">
            <ul>
              <li>
                <a href="#">My page</a>
              </li>
              <li>
                <a href="/user-news">My news</a>
              </li>
              <li>
                <a href="javascript:formSubmit()">Exit</a>
                <c:url value="/logout" var="logoutUrl" />
                <form action="${logoutUrl}" method="post" id="logoutForm">
                  <input type="hidden" name="${_csrf.parameterName}"
                         value="${_csrf.token}" />
                </form>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </header>
    <main>
      <div class="container">
        <div class="img-block">
          <img class="news-img" src="../img/img1.jpg" />
        </div>
        <div class="info-block">
          <table class="info-table">
            <tr>
              <td><p class="info-name">Name</p></td>
              <td><p class="info-value"><c:out value="${sessionScope.username}"/></p></td>
            </tr>
            <tr>
              <td><p class="info-name">E-mail</p></td>
              <td><p class="info-value"><c:out value="${sessionScope.email}"/></p></td>
            </tr>
          </table>
        </div>
        <h1 class="article-name">My HashTags</h1>
        <div class="my-tags-container">
          <form>
            <ul class="list-my-tags">
              <li>
                <div id="div-close-1" class="list-my-tags-block">
                  <label for="close-1">Politics</label>
                  <button class="modal-content-close" id="close-1" type="button"
                        title="Close" onclick="removeTag(this)">Close</button><br></div>
              </li>
              <li><div id="div-close-2" class="list-my-tags-block">
                <label for="close-2">Germany</label>
                <button class="modal-content-close" id="close-2" type="button"
                        title="Close" onclick="removeTag(this)">Close</button></div>
              </li>
              <li><div id="div-close-3" class="list-my-tags-block">
                <label for="close-3">Trump</label>
                <button class="modal-content-close" id="close-3" type="button"
                        title="Close" onclick="removeTag(this)">Close</button></div>
              </li>
            </ul>
            <input class="submit-button" type="submit" value="Save" />
          </form>
        </div>
        <h1 class="article-name">HashTags</h1>
        <div class="tags-container">
          <form>
            <ul class="list-tags">
              <li><input class="checkbox" type="checkbox"
                     value="!!!!" /><label class="select-tag">Windows 2000</label></li>
              <li><input class="checkbox" type="checkbox"
                   value="!!!!" /><label class="select-tag">Windows 1</label></li>
              <li><input class="checkbox" type="checkbox"
                   value="!!!!" /><label class="select-tag">Windows 2</label></li>
              <li><input class="checkbox" type="checkbox"
                   value="!!!!" /><label class="select-tag">Windows 3</label></li>
              <li><input class="checkbox" type="checkbox"
                   value="!!!!" /><label class="select-tag">Windows 4</label></li>
            </ul>
            <input class="submit-button" type="submit" value="Save" />
          </form>
        </div>
      </div>
    </main>
  </body>
</html>