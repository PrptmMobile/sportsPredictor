<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<menu>

    <ul>
        <li><a href="login.jsp" ><c:out value="${i28}"/></a></li>
        <li><a href="signUp.jsp" ><c:out value="${i29}"/></a></li>
    </ul>
    <a href="locale?lang=ru">RU</a> | <a href="locale?lang=en">EN</a>
</menu>
</body>
</html>
