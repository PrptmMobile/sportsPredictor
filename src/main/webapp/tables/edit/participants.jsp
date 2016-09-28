<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>League roster</title>
</head>
<body>
<jsp:useBean id="teamsList" class="com.etu3892.db.TeamsRepository" scope="application"/>
<c:set var="teams" value="${teamsList.nnStTeams}" />
<c:forEach var="team" items="${teams}">
    <jsp:setProperty name="teamsList" property="${team.getTeamId()}" value="${team.getTeam()}"/>
</c:forEach>
<c:set var="roster" value="${roster}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th><c:out value="${name}"/></th>
        <th>Actions</th>
    </tr>
    <c:forEach var="part" items="${roster}">
        <tr>
            <td> <c:out value="${part.getTeamPartId()}"/></td>
            <td><jsp:getProperty name="teamsList" property="${part.getTeamId()}"/></td>
            <td> <a href="remove?type=3&id=${part.getTeamPartId()}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create?type=3" method="post">
            <td> New</td>
            <td> <input type="text" name="team"></td>
            <td>
                <select name="country">
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="sport">
                    <c:forEach var="sport" items="${sports}">
                        <option value="${sport.getSportId()}"><c:out value="${sport.getSport()}"/></option>
                    </c:forEach>
                </select><br>
            </td>
            <td> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>
<br>
<a href="/administrator">Return to admin panel</a>
</body>
</html>
