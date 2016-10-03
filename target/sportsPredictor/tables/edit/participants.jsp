<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>League roster</title>
</head>
<body>
<c:set var="teams" value="${teams}" />
<c:set var="roster" value="${roster}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th><c:out value="${name}"/></th>
        <th>Actions</th>
    </tr>
    <c:forEach var="part" items="${roster}">
        <tr>
            <td> <c:out value="${part.getTeampartId()}"/></td>
            <td><c:out value="${part.getTeam().getTeam()}"/></td>
            <td> <a href="remove?type=4&id=${part.getTeampartId()}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create" method="post">
            <input type="hidden" name="type" value="${4}">
            <input type="hidden" name="lid" value="${id}">
            <td> Add</td>
            <td>
                <select name="team">
                    <c:forEach var="team" items="${teams}">
                        <option value="${team.getTeamId()}"><c:out value="${team.getTeam()}"/></option>
                    </c:forEach>
                </select><br>
            </td>
            <td> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>
<br>
<a href="administrator">Return to admin panel</a>
</body>
</html>
