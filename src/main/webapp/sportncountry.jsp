<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i49}"/></title>
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<h2><c:out value="${i50}"/></h2>
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
    <input type="submit" value="<c:out value="${i51}"/>">
</form>
<br>
<a href="index" ><c:out value="${i52}"/></a>
</body>
</html>
