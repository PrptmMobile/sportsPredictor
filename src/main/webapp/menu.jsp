<%@ page contentType="text/html;charset=cp1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Main menu</title>
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<div id="container">
<div id = "headercont">
    <div id="headerleft">
        <ex:time/> <br>
        <a href="locale?lang=ru">RU</a> | <a href="locale?lang=en">EN</a> <br>
        <c:out value="${i271}"/>: <%= session.getAttribute("username") %>  <a href="logout"><c:out value="${i272}"/></a>
        <br>
    </div>
    <div id="headerright">
        <ul>
            <li><a href="index" ><c:out value="${i23}"/></a></li> <li>|</li>
            <li><a href="predict?id=9" ><c:out value="${i24}"/></a></li> <li>|</li>
            <li><a href="ratings?id=9" ><c:out value="${i25}"/></a></li> <li>|</li>
            <li><a href="leaguetable?id=9" ><c:out value="${i26}"/></a></li> <li>|</li>
            <li><a href="cabinet" ><c:out value="${i27}"/></a></li> <li>|</li>
        </ul>
    </div>

</div>
    </div>

</body>
</html>
