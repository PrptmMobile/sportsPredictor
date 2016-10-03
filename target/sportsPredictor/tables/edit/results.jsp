<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>Matches</title>
</head>
<body>
<c:set var="matches" value="${matches}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Home</th>
        <th>Away</th>
        <th>Datetime</th>
        <th colspan="2">Score</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="match" items="${matches}">
        <tr>
            <td> <c:out value="${match.getMatchId()}"/></td>
            <td><c:out value="${match.getHome().getTeam()}"/></td>
            <td><c:out value="${match.getAway().getTeam()}"/></td>
            <td><c:out value="${match.getDatetime().toString()}"/></td>
            <form action="update" method="post">
                <input type="hidden" name="type" value="${5}">
                <input type="hidden" name="id" value="${match.getMatchId()}">
            <td><input type="number" name="homeGls" min="0"></td>
            <td><input type="number" name="awayGls" min="0"></td>
            <td><input type="submit" value="Confirm"></td>
            </form>
        </tr>
    </c:forEach>

</table>
<br>
<a href="administrator">Return to admin panel</a>
</body>
</html>

</body>
</html>
