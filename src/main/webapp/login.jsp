<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>
<html>
<head>
    <title><c:out value="${i19}"/></title>
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<div align="left"><jsp:include page="notLogged.jsp"/></div>
<link rel="stylesheet" href="css/center.css">
<div class="center">
<form action="login" method="post">
    <label ><c:out value="${i20}"/></label><br>
    <input type="text" name="name"><br>
    <label ><c:out value="${i21}"/></label><br>
    <input type="password" name="password"><br>

    <input type="submit" value="Log in"><br>
    <b><c:out value="${Error}"/></b><br>
</form>

<form action="sendpassword" method="post">
    <label ><c:out value="${i22}"/></label><br>
    <input type="text" name="email"><br>

    <input type="submit" value="Send"><br>
    <b><c:out value="${ErrorPswd}"/></b><br>
</form>
</div>
</body>
</html>
