<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<div align="left"><jsp:include page="notLogged.jsp"/></div>
<link rel="stylesheet" href="css/center.css">
<div class="center">
<form action="login" method="post">
    <label >Login</label><br>
    <input type="text" name="name"><br>
    <label >Password</label><br>
    <input type="password" name="password"><br>

    <input type="submit" value="Log in"><br>
    <b><c:out value="${Error}"/></b><br>
</form>

<form action="sendpassword" method="post">
    <label >Forgot your password? Type your email and we will send it to you/</label><br>
    <input type="text" name="email"><br>

    <input type="submit" value="Send"><br>
    <b><c:out value="${ErrorPswd}"/></b><br>
</form>
</div>
</body>
</html>
