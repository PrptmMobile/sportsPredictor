<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit sport name</title>
</head>
<body>
<form action="../../update" method="post">
    <input type="hidden" name="type" value="${1}">
    <input type="hidden" name="lid" value="${param.id}">
    <label >ID</label><br>
    <input type="text" name="spid" value="${param.id}"  disabled><br>
    <label >Sport name</label><br>
    <input type="text" name="sport" value="${param.sport}"><br><br>
    <input type="submit" value="Update">
</form>

</body>
</html>
