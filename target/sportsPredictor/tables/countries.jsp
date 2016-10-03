<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<c:set var="countries" value="${countries}" />
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach var="country" items="${countries}">
      <tr>
          <td> <c:out value="${country.getCountryId()}"/></td>
          <td> <c:out value="${country.getCountry()}"/></td>
          <td> <a href="tables/edit/country.jsp?id=${country.getCountryId()}&country=${country.getCountry()}">Edit</a> </td>
          <td>   <a href="remove?type=0&id=${country.getCountryId()}&country=${country.getCountry()}">Delete</a></td>
      </tr>
    </c:forEach>
    <tr>
        <form action="create" method="post">
            <input type="hidden" name="type" value="${0}">
            <td> New</td>
            <td> <input type="text" name="country"></td>
            <td colspan="2"> <input type="submit" value="Add" align="center"></td>
        </form>
    </tr>
</table>

</body>
</html>
