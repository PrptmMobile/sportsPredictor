<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
</head>
<body>
<c:set var="teams" value="${roster}" />
<c:set var="matches" value="${matches}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Home</th>
        <th>Away</th>
        <th>Datetime</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="match" items="${matches}">
        <tr>
            <td> <c:out value="${match.getMatchId()}"/></td>
            <td><c:out value="${match.getHome().getTeam()}"/></td>
            <td><c:out value="${match.getAway().getTeam()}"/></td>
            <td><c:out value="${match.getDatetime().toString()}"/></td>
            <td> <a href="remove?type=5&id=${match.getMatchId()}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create" method="post">
            <input type="hidden" name="type" value="${5}">
            <input type="hidden" name="lid" value="${id}">
            <td> Add</td>
            <td>
                <select name="home">
                    <c:forEach var="team" items="${teams}">
                        <option value="${team.getTeam().getTeamId()}"><c:out value="${team.getTeam().getTeam()}"/></option>
                    </c:forEach>
                </select><br>
            </td>
            <td>
                <select name="away">
                    <c:forEach var="team" items="${teams}">
                        <option value="${team.getTeam().getTeamId()}"><c:out value="${team.getTeam().getTeam()}"/></option>
                    </c:forEach>
                </select><br>
            </td>
            <td><input type="datetime-local" name="dt" ></td>
            <td> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>
<br>
<a href="administrator">Return to admin panel</a>
</body>
</html>
