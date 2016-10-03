<%@ page contentType="text/html;charset=cp1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" uri="/WEB-INF/time.tld"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Main menu</title>
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <ul>
    <li><a href="index" >Home</a></li>
    <li><a href="predict?id=9" >Predicts</a></li>
    <li><a href="ratings?id=9" >Predictors ratings</a></li>
    <li><a href="leaguetable?id=9" >League tables</a></li>
    <li><a href="cabinet" >Profile</a></li>
    </ul>
    <ex:time/>
<br>
    You are logged in as: <%= session.getAttribute("username") %>  <a href="logout">Exit</a>
</body>
</html>
