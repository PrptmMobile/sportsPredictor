<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ratings</title>
</head>
<body>
<jsp:useBean id="leaguesList" class="com.etu3892.db.mysql.MySQLLeagueDAO" scope="application"/>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:include page="menu.jsp"/>
<br><br><br><br>
<c:set var="leagues" value="${leaguesList.beanLeagues}" />
|<c:forEach var="league" items="${leagues}">
    <a href="ratings?id=${league.getLeagueId()}"><c:out value="${league.getLeague()}"/></a> |
</c:forEach> <br><br><br>
<c:if test="${name ne 'None'}">
    <h3><c:out value="${name}"/></h3>
    <table border="1" style="table-layout: fixed; float: left">
        <tr>
            <th>P</th>
        </tr>
        <c:forEach var="i" begin="1" end="${ratings.size()}">
            <tr>
                <td><c:out value="${i}"/></td>
            </tr>
        </c:forEach>
    </table>
    <c:set var="ratings" value="${ratings}"/>
    <table border="1">
        <tr>
            <th>User</th>
            <th>Points</th>
            <th>Scores</th>
        </tr>
        <c:forEach var="part" items="${ratings}">
            <tr>
                <td><c:out value="${part.getUser().getUsername()}"/></td>
                <td><c:out value="${part.getPoints()}"/></td>
                <td><c:out value="${part.getScores()}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <h3>Your previous predicts</h3>
    <table >
        <c:set var="predicts" value="${predicts}"/>
        <c:forEach var="predict" items="${predicts}">
            <tr>
                <td><c:out value="${predict.getMatch().getDatetime().toString()}"/></td>
                <td><c:out value="${predict.getMatch().getHome().getTeam()}"/></td>
                <td>-</td>
                <td><c:out value="${predict.getMatch().getAway().getTeam()}"/></td>
                <td><c:out value="${predict.getHomePr()}"/></td>
                <td>-</td>
                <td><c:out value="${predict.getAwayPr()}"/></td>
                <td>(<c:out value="${predict.getPoints()}"/> points)</td>
                </form>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
