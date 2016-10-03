<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title><c:out value="${i42}"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/center.css">
</head>
<body>
<jsp:directive.include file="locale.jsp" />
<jsp:include page="notLogged.jsp"/>
<jsp:useBean id="countryList" class="com.etu3892.db.mysql.MySQLCountriesDAO" scope="application"/>
<jsp:useBean id="teamList" class="com.etu3892.db.mysql.MySQLTeamsDAO" scope="application"/>
<div class="center">
    <form action="sportncountry" method="post">
        <label ><c:out value="${i43}"/></label><br>
        <input type="text" name="name" value="${name}"><b><c:out value="${Error1}"/></b><br>
        <label ><c:out value="${i44}"/></label><br>
        <input type="password" name="password"><br>
        <label ><c:out value="${i45}"/></label><br>
        <input type="password" name="passwordagain"><b><c:out value="${Error2}"/></b><br><br>
        <label ><c:out value="${i46}"/></label><br>
        <input type="text" name="email" value="${email}"><b><c:out value="${Error3}"/></b><br><br>
        <label ><c:out value="${i47}"/></label><br>
        <c:set var="countries" value="${countryList.countries}" />
        <select name="country">
            <c:forEach var="country" items="${countries}">
                <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
            </c:forEach>
        </select><br>

            <input type="submit" value="<c:out value="${i48}"/>"><br>
        <br>
    </form>
</div>
</body>
</html>
