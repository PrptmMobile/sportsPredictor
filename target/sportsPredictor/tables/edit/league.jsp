<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit league</title>
</head>
<body>
<jsp:useBean id="sportList" class="com.etu3892.db.mysql.MySQLSportsDAO" scope="application"/>
<jsp:useBean id="countryList" class="com.etu3892.db.mysql.MySQLCountriesDAO" scope="application"/>
<form action="../../update" method="post">
    <input type="hidden" name="type" value="${2}">
    <input type="hidden" name="lid" value="${param.id}">
    <label >ID</label><br>
    <input type="text" name="spid" value="${param.id}"  disabled><br>
    <label >League name</label><br>
    <input type="text" name="league" value="${param.league}"><br>
    <label >Country</label><br>
    <c:set var="countries" value="${countryList.countries}" />
    <select name="country">
        <option selected value="${param.cid}">No changes</option>
        <c:forEach var="country" items="${countries}">
            <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
        </c:forEach>
    </select><br>

    <label >Sport</label><br>
    <c:set var="sports" value="${sportList.sports}" />
    <select name="sport">
        <option selected value="${param.sid}">No changes</option>
        <c:forEach var="sport" items="${sports}">
            <option value="${sport.getSportId()}"><c:out value="${sport.getSport()}"/></option>
        </c:forEach>
    </select><br>
    <br><input type="submit" value="Update">
</form>

</body>
</html>
