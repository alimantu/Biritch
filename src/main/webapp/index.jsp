<%--
  Created by IntelliJ IDEA.
  User: Alimantu
  Date: 03/09/16
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="body/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Hello React!</title>
        <script src="build/react.js"></script>
        <script src="build/react-dom.js"></script>
        <script src="https://npmcdn.com/babel-core@5.8.38/browser.min.js"></script>
    </head>
    <body>
    <div id="example"></div>
    <script type="body/babel">
        ReactDOM.render(
                <h1>Hello, world!</h1>,
                document.getElementById('example')
        );
    </script>
</body>
<%--<head>--%>
    <%--<title>Some temp title</title>--%>
<%--</head>--%>
<%--<body>--%>

    <%--<h1>Here is some body</h1>--%>
    <%--<form action="test" method="POST">--%>
        <%--<input type="submit" value="Test"/>--%>
    <%--</form>--%>
<%--</body>--%>
</html>
