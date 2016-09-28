<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leagues</title>
</head>
<body>
<c:set var="leagues" value="${leagues}" />
<c:set var="sountries" value="${countries}" />
<c:set var="sports" value="${sports}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country ID</th>
        <th>Sport ID</th>
        <th colspan="4">Actions</th>
    </tr>
    <c:forEach var="league" items="${leagues}">
        <tr>
            <td> <c:out value="${league.getLeagueId()}"/></td>
            <td> <c:out value="${league.getLeague()}"/></td>
            <td> <c:out value="${league.getCountryId()}"/></td>
            <td> <c:out value="${league.getSportId()}"/></td>
            <td> <a href="tables/edit/league.jsp?id=${league.getLeagueId()}&league=${league.getLeague()}&cid=${league.getCountryId()}&sid=${league.getSportId()}">Edit</a> </td>
            <td> <a href="remove?type=2&id=${league.getLeagueId()}">Delete</a></td>
            <td> <a href="participants?id=${league.getLeagueId()}&name=${league.getLeague()}">League roster</a></td>
            <td> <a href="tables/edit/matches?id=${league.getLeagueId()}">Add matches</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create?type=2" method="post">
            <td> New</td>
            <td> <input type="text" name="league"></td>
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
            <td colspan="4"> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>
</body>
</html>
