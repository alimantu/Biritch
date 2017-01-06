<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link href="../css/user-service.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User-news</title>
    <script>
      function formSubmit() {
        document.getElementById("logoutForm").submit();
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
                <a href="/user-profile">My page</a>
              </li>
              <li>
                <a href="#">My news</a>
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
        <h1 class="article-name">Article name</h1>
        <div class="tags">
          Here tags
        </div>
        <div class="article-info">
          <%--<input class="prev" type="button" onclick="prev()" value="prev" />--%>
          <a href="#" class="prev" onclick="prev(); return false">prev</a>
          <div class="article-content">
            Here news
          </div>
          <a href="#" class="next" onclick="next(); return false">next</a>
          <%--<input class="next" type="button" onclick="next()" value="next" />--%>
        </div>
      </div>
    </main>
    <footer>
      <div class="container">
        <h2 class="recommends">Like to get nice recommends next time?<br>
          Just rate this article!</h2>
        <div class="rating-container">
          <form class="rating">
            <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="5">5 stars</label>
            <input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="4">4 stars</label>
            <input type="radio" id="star3" name="rating" value="3" checked/><label for="star3" title="3">3 stars</label>
            <input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="2">2 stars</label>
            <input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="1">1 star</label>
          </form>
        </div>
      </div>
    </footer>
  </body>
</html>
