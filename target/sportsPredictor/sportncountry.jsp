<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your favourite club</title>
</head>
<body>
<h2>Choose the kind of sport & country</h2>
<jsp:useBean id="sportList" class="com.etu3892.db.mysql.MySQLSportsDAO" scope="application"/>
<jsp:useBean id="countryList" class="com.etu3892.db.mysql.MySQLCountriesDAO" scope="application"/>
<form action="teamselect" method="post">
    <c:set var="sports" value="${sportList.sports}" />
    <select name="sports">
    <c:forEach var="sport" items="${sports}">
        <option value="${sport.getSportId()}"><c:out value="${sport.getSport()}"/></option>
    </c:forEach>
    </select><br>

    <c:set var="countries" value="${countryList.countries}" />
    <select name="countries">
    <c:forEach var="country" items="${countries}">
        <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
    </c:forEach>
    </select><br>
    <input type="submit" value="Choose team">
</form>
<br>
<a href="index" >I don`t have favourite team</a>
</body>
</html>
