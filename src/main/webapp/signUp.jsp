<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="left"><jsp:include page="notLogged.jsp"/></div>
<jsp:useBean id="countryList" class="com.etu3892.db.mysql.MySQLCountriesDAO" scope="application"/>
<jsp:useBean id="teamList" class="com.etu3892.db.mysql.MySQLTeamsDAO" scope="application"/>
<div class="forma mail">
    <form action="sportncountry" method="post">
        <label >Login</label><br>
        <input type="text" name="name" value="${name}"><b><c:out value="${Error1}"/></b><br>
        <label >Password</label><br>
        <input type="password" name="password"><br>
        <label >Password (again)</label><br>
        <input type="password" name="passwordagain"><b><c:out value="${Error2}"/></b><br><br>
        <label >E-mail</label><br>
        <input type="text" name="email" value="${email}"><b><c:out value="${Error3}"/></b><br><br>
        <label >Choose your country</label><br>
        <c:set var="countries" value="${countryList.countries}" />
        <select name="country">
            <c:forEach var="country" items="${countries}">
                <option value="${country.getCountryId()}"><c:out value="${country.getCountry()}"/></option>
            </c:forEach>
        </select><br>

            <input type="submit" value="Sign up"><br>
        <br>
    </form>
</div>
</body>
</html>
