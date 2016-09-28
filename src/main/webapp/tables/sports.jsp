<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sports</title>
</head>
<body>
<c:set var="sports" value="${sports}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach var="sport" items="${sports}">
        <tr>
            <td> <c:out value="${sport.getSportId()}"/></td>
            <td> <c:out value="${sport.getSport()}"/></td>
            <td> <a href="tables/edit/sport.jsp?id=${sport.getSportId()}&sport=${sport.getSport()}">Edit</a> </td>
            <td>   <a href="remove?type=1&id=${sport.getSportId()}&sport=${sport.getSport()}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <form action="create?type=1" method="post">
            <td> New</td>
            <td> <input type="text" name="sport"></td>
            <td colspan="2"> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>

</body>
</html>
