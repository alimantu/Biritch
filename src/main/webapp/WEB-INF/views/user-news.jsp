<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User-news</title>
  </head>
  <body>
    <header class="header">
      <div class="container">
        <div class="user-menu">
          <nav class="menu">
            <ul>
              <li class="active">
                <a href="#">My page</a>
              </li>
              <li>
                <a href="#">My news</a>
              </li>
              <li>
                <a href="#">Exit</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </header>
    <main>
      <div class="container">
        <img src="img/news-img.png" />
        <div class="article">
          <input type="button" onclick="prev()" value="prev" />
          <div class="article-info">
            <h1>Article name</h1>
            <div class="tags">

            </div>
            <div class="article-content">

            </div>
          </div>
          <input type="button" onclick="next()" value="next" />
        </div>
      </div>
    </main>
    <footer>
      <div class="container">
        <h2>Like to get nice recommends next time? Just
          rate this article!</h2>
      </div>
    </footer>
  </body>
</html>
