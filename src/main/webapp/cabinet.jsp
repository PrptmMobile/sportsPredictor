<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${i1}"/></title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
<jsp:directive.include file="locale.jsp" />
<jsp:include page="menu.jsp"/>
    <div id="maincont">
        <div id="mainleft">
            <h2></h2>
<form action="updateprofile" method="post">
    <label><c:out value="${i2}"/></label><br>
    <input type="text" name="username" value="${username}"/><br>
    <label><c:out value="${i3}"/>: </label><br>
    <input type="text" name="email" value="${email}"/><br>
    <label><c:out value="${i4}"/>: </label><br>
    <input type="password" name="newpswd" value="${newpswd}"/><br><br>

    <label><c:out value="${i5}"/> </label><br>
    <input type="password" name="pswd" value="<c:out value="${i51}"/>"/><br>

    <input type="submit" value="Update"/><br>
    <c:out value="${message}"/>
</form> </div>
        <div id="mainright">
            <h2></h2>
    <c:out value="${i6}"/>: ${teamname} <br>
    <c:out value="${i7}"/>:<br>
    <jsp:useBean id="sportList" class="com.etu3892.db.mysql.MySQLSportsDAO" scope="application"/>
    <jsp:useBean id="countryList" class="com.etu3892.db.mysql.MySQLCountriesDAO" scope="application"/>
    <form action="teamselect?username=${username}" method="post">
        <c:set var="sports" value="${sportList.sports}" />
        <c:out value="${i8}"/><br>
        <select name="sports">
            <c:forEach var="sport" items="${sports}">
                <option value="${sport.getSportId()}"><c:out value="${sport.getSport()}"/></option>
            </c:forEach>
        </select><br>
        <c:out value="${i9}"/><br>
        <c:set var="countries" value="${countryList.countries}" />
        <select name="countries">
            <c:forEach var="country" items="${countries}">
                <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
            </c:forEach>
        </select><br>
        <input type="submit" value="<c:out value="${i12}"/>">
    </form>
            </div>
        <div id="bottom"></div>
</div>
</div>
</body>
</html>
