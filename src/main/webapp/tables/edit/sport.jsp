<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit sport name</title>
</head>
<body>
<form action="../../update?type=1&id=${param.id}" method="post">
    <label >ID</label><br>
    <input type="text" name="spid" value="${param.id}"  disabled><br>
    <label >Sport name</label><br>
    <input type="text" name="sport" value="${param.sport}"><br><br>
    <input type="submit" value="Update">
</form>

</body>
</html>
