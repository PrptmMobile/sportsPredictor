<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit country name</title>
</head>
<body>
<form action="../../update?type=0&id=${param.id}" method="post">
    <label >ID</label><br>
    <input type="text" name="countryid" value="${param.id}"  disabled><br>
    <label >Country name</label><br>
    <input type="text" name="country" value="${param.country}"><br><br>
    <input type="submit" value="Update">
</form>

</body>
</html>
