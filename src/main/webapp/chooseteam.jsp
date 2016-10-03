<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose team!</title>
</head>
<body>
<h2>Choose your team! (You may change it on your profile page)</h2>
<form action="endreg" method="post">
    <input type="hidden" name="username" value="${username}">
    <c:set var="teams" value="${teamList}" />
    <select name="team">
        <c:forEach var="team" items="${teams}">
            <option value="${team.getTeamId()}"><c:out value="${team.getTeam()}"/></option>
        </c:forEach>
    </select><br>


    <input type="submit" value="Confirm">
</form>

<a href="signUp.jsp" >I`m sure I have no ideas about my favourite team</a>
</body>
</html>