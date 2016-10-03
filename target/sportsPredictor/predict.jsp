<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i30}"/></title>
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<jsp:useBean id="leaguesList" class="com.etu3892.db.mysql.MySQLLeagueDAO" scope="application"/>
<jsp:include page="menu.jsp"/>
<br><br><br><br>
<c:set var="leagues" value="${leaguesList.beanLeagues}" />
|<c:forEach var="league" items="${leagues}">
<a href="predict?id=${league.getLeagueId()}"><c:out value="${league.getLeague()}"/></a> |
    </c:forEach> <br><br><br>
    <c:if test="${name ne 'None'}">
    <h3><c:out value="${i31}"/> <c:out value="${name}"/></h3>

    <table border="1">
        <tr>
            <th><c:out value="${i32}"/></th>
            <th><c:out value="${i33}"/></th>
            <th><c:out value="${i34}"/></th>
            <th colspan="2"><c:out value="${i35}"/></th>
            <th>ok</th>
        </tr>
        <c:set var="matches" value="${matches}"/>
        <c:forEach var="match" items="${matches}">
            <tr>
                <td><c:out value="${match.getDatetime().toString()}"/></td>
                <td><c:out value="${match.getHome().getTeam()}"/></td>
                <td><c:out value="${match.getAway().getTeam()}"/></td>
                <form action="update" method="post">
                    <input type="hidden" name="type" value="${11}">
                    <input type="hidden" name="matchId" value="${match.matchId}">
                <td><input type="number" name="homeGls" min="0"></td>
                <td><input type="number" name="awayGls" min="0"></td>
                <td><input type="submit" value="Ok"> </td>
                    </form>
            </tr>
        </c:forEach>
    </table>
    <br><br>
        <h3><c:out value="${i36}"/></h3>
        <table >
            <c:set var="predicts" value="${predicts}"/>
            <c:forEach var="predict" items="${predicts}">
                <tr>
                    <td><c:out value="${predict.getMatch().getDatetime().toString()}"/></td>
                    <td><c:out value="${predict.getMatch().getHome().getTeam()}"/></td>
                    <td><c:out value="${predict.getMatch().getAway().getTeam()}"/></td>
                    <td><c:out value="${predict.getHomePr()}"/></td>
                    <td>-</td>
                    <td><c:out value="${predict.getAwayPr()}"/></td>
                    </form>
                </tr>
            </c:forEach>
        </table>

    </c:if>
</body>
</html>
