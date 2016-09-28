<%@ page contentType="text/html;charset=cp1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Main menu</title>
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <ul>
    <li><a href="" >Home</a></li>
    <li><a href="" >Ratings</a></li>
    <li><a href="" >Stats</a></li>
    <li><a href="" >Predicts</a></li>
    <li><a href="cabinet" >Profile</a></li>
    </ul>
<br>

You are logged in as: <%= session.getAttribute("username") %> <a href="login">Exit</a>
</body>
</html>
