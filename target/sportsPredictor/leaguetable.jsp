<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i17}"/></title>
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<jsp:useBean id="leaguesList" class="com.etu3892.db.mysql.MySQLLeagueDAO" scope="application"/>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:include page="menu.jsp"/>
<br><br><br><br>
<c:set var="leagues" value="${leaguesList.beanLeagues}" />
    |<c:forEach var="league" items="${leagues}">
                <a href="leaguetable?id=${league.getLeagueId()}"><c:out value="${league.getLeague()}"/></a> |
    </c:forEach> <br><br><br>
<c:if test="${name ne 'None'}">
    <h3><c:out value="${name}"/></h3>
    <table border="1" style="table-layout: fixed; float: left">
        <tr>
            <th>P</th>
        </tr>
        <c:forEach var="i" begin="1" end="${table.size()}">
            <tr>
                <td><c:out value="${i}"/></td>
            </tr>
        </c:forEach>
    </table>
    <c:set var="table" value="${table}"/>
    <table border="1">
        <tr>
        <th>Team</th>
        <th>PLD</th>
        <th>GS</th>
        <th>GC</th>
        <th>PTS</th>
        </tr>
        <c:forEach var="team" items="${table}">
            <tr>
            <td><c:out value="${team.getTeam().getTeam()}"/></td>
            <td><c:out value="${team.getPld()}"/></td>
            <td><c:out value="${team.getGs()}"/></td>
            <td><c:out value="${team.getGc()}"/></td>
            <td><c:out value="${team.getPts()}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <h3><c:out value="${i18}"/></h3>
    <c:set var="matches" value="${matches}"/>
    <c:forEach var="match" items="${matches}">
        <c:out value="${match.getDatetime().toString()}"/>  <c:out value="${match.getHome().getTeam()}"/> - <c:out value="${match.getAway().getTeam()}"/>    <c:out value="${match.getHomeGls()}"/>:<c:out value="${match.getAwayGls()}"/><br>
    </c:forEach>

</c:if>
</body>
</html>
