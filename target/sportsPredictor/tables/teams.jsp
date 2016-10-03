<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams</title>
</head>
<body>
<c:set var="teams" value="${teams}" />
<c:set var="sountries" value="${countries}" />
<c:set var="sports" value="${sports}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Sport</th>
        <th>Country</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach var="team" items="${teams}">
        <tr>
            <td> <c:out value="${team.getTeamId()}"/></td>
            <td> <c:out value="${team.getTeam()}"/></td>
            <td> <c:out value="${team.getSportName()}"/></td>
            <td> <c:out value="${team.getCountryName()}"/></td>
            <td> <a href="tables/edit/team.jsp?id=${team.getTeamId()}&team=${team.getTeam()}&cid=${team.getCountry().getCountryId()}&sid=${team.getSport().getSportId()}">Edit</a> </td>
            <td> <a href="remove?type=3&id=${team.getTeamId()}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create" method="post">
            <input type="hidden" name="type" value="${3}">
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
            <td colspan="2"> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>
</body>
</html>
