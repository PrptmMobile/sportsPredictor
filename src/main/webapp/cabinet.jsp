<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
</head>

<body>
<div align="left"> <jsp:include page="menu.jsp"/></div>
<div align="center">
<form action="updateprofile" method="post">
    <label>Change username: </label><br>
    <input type="text" name="username" value="${username}"/><br>
    <label>Change e-mail: </label><br>
    <input type="text" name="email" value="${email}"/><br>
    <label>New password: </label><br>
    <input type="password" name="newpswd" value="${newpswd}"/><br><br>

    <label>Password </label><br>
    <input type="password" name="pswd" value=""/><br>

    <input type="submit" value="Update"/><br>
    <c:out value="${message}"/>
</form>

    Your favourite team: ${teamname} <br>
    Change:<br>
    <jsp:useBean id="sportList" class="com.etu3892.db.SportsRepository" scope="application"/>
    <jsp:useBean id="countryList" class="com.etu3892.db.CountriesRepository" scope="application"/>
    <form action="teamselect?username=${username}" method="post">
        <c:set var="sports" value="${sportList.sports}" />
        Type of sport<br>
        <select name="sports">
            <c:forEach var="sport" items="${sports}">
                <option value="${sport.getSportId()}"><c:out value="${sport.getSport()}"/></option>
            </c:forEach>
        </select><br>
        Country<br>
        <c:set var="countries" value="${countryList.countries}" />
        <select name="countries">
            <c:forEach var="country" items="${countries}">
                <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Choose team">
    </form>
</div>
</body>
</html>
