<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title>
</head>
<body>
<jsp:include page="notLogged.jsp"/>
<br>
Ooops! Try <a href="login.jsp">log in</a> or <a href="signUp.jsp">sign up</a>.
</body>
</html>
