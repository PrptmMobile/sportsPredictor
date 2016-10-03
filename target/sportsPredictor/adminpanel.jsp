<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin`s panel</title>
    <style>
        .korpus > div, .korpus > input { display: none; }

        .korpus label { padding: 5px; border: 1px solid #aaa; line-height: 28px; cursor: pointer; position: relative; bottom: 1px; background: #fff; }
        .korpus input[type="radio"]:checked + label { border-bottom: 2px solid #fff; }

        .korpus > input:nth-of-type(1):checked ~ div:nth-of-type(1),
        .korpus > input:nth-of-type(2):checked ~ div:nth-of-type(2),
        .korpus > input:nth-of-type(3):checked ~ div:nth-of-type(3),
        .korpus > input:nth-of-type(4):checked ~ div:nth-of-type(4),
        .korpus > input:nth-of-type(5):checked ~ div:nth-of-type(5){ display: block; padding: 5px; border: 1px solid #aaa; }
    </style>
</head>
<body>
<h2>Admin`s Panel</h2>
<div class="korpus">
    <input type="radio" name="odin" checked="checked" id="vkl1"/><label for="vkl1">Countries</label>
    <input type="radio" name="odin" id="vkl2"/><label for="vkl2">Sports</label>
    <input type="radio" name="odin" id="vkl3"/><label for="vkl3">Leagues</label>
    <input type="radio" name="odin" id="vkl4"/><label for="vkl4">Teams</label>
    <div><jsp:include page="showadmin?table=0"/></div>
    <div><jsp:include page="showadmin?table=1"/></div>
    <div><jsp:include page="showadmin?table=2"/></div>
    <div><jsp:include page="showadmin?table=3"/></div>
</div>

<a href="index">Get back to main page</a>
</body>
</html>
