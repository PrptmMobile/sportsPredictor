<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<div id="container">
    <div id = "headercont">
        <div id="headerleft">
            <ex:time/> <br>
            <a href="locale?lang=ru">RU</a> | <a href="locale?lang=en">EN</a>
        </div>
        <div id="headerright">
    <ul>
        <li><a href="login.jsp" ><c:out value="${i28}"/></a></li> <li>|</li>
        <li><a href="signUp.jsp" ><c:out value="${i29}"/></a></li> <li>|</li>
    </ul>
            </div>
    </div>
</div>
</body>
</html>
