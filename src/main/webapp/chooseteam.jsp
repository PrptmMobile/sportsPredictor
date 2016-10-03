<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i10}"/></title>
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<h2><c:out value="${i11}"/></h2>
<form action="endreg" method="post">
    <input type="hidden" name="username" value="${username}">
    <c:set var="teams" value="${teamList}" />
    <select name="team">
        <c:forEach var="team" items="${teams}">
            <option value="${team.getTeamId()}"><c:out value="${team.getTeam()}"/></option>
        </c:forEach>
    </select><br>


    <input type="submit" value="<c:out value="${i12}"/>">
</form>

<a href="signUp.jsp" ><c:out value="${i13}"/></a>
</body>
</html>
