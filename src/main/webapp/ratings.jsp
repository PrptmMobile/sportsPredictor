<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i37}"/></title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:directive.include file="locale.jsp" />
<jsp:useBean id="leaguesList" class="com.etu3892.db.mysql.MySQLLeagueDAO" scope="application"/>
<jsp:include page="menu.jsp"/>
<div id="container">
    <br>
    <c:set var="leagues" value="${leaguesList.beanLeagues}" />
    |<c:forEach var="league" items="${leagues}">
    <a href="ratings?id=${league.getLeagueId()}"><c:out value="${league.getLeague()}"/></a> |

</c:forEach>
    <div id="maincont">
<c:if test="${name ne 'None'}">

            <h2><c:out value="${i41}"/></h2>
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
                        <td>(<c:out value="${predict.getPoints()}"/>)</td>
                        </form>
                    </tr>
                </c:forEach>
            </table>


            <h2><c:out value="${name}"/></h2>
            <c:set var="ratings" value="${ratings}"/>
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

            <table border="1">
                <tr>
                    <th><c:out value="${i38}"/></th>
                    <th><c:out value="${i39}"/></th>
                    <th><c:out value="${i40}"/></th>
                </tr>
                <c:forEach var="part" items="${ratings}">
                    <tr>
                        <td><c:out value="${part.getUser().getUsername()}"/></td>
                        <td><c:out value="${part.getPoints()}"/></td>
                        <td><c:out value="${part.getScores()}"/></td>
                    </tr>
                </c:forEach>
            </table>

</c:if>
            <div id="bottom"></div>
    </div>
</div>
</body>
</html>
