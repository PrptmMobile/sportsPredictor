<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.language == 'en'}">
    <fmt:setBundle basename="en" var="language"/>
</c:if>
<c:if test="${sessionScope.language == 'ru'}">
    <fmt:setBundle basename="cyr" var="language"/>
</c:if>
<c:if test="${sessionScope.language == 'default'}">
    <fmt:setBundle basename="cyr" var="language"/>
</c:if>
<c:if test="${sessionScope.language == null}">
    <fmt:setBundle basename="en" var="language"/>
</c:if>


<fmt:message key="cabinet.edit" bundle="${language}" var="i1" />
<fmt:message key="cabinet.username" bundle="${language}" var="i2" />
<fmt:message key="cabinet.email" bundle="${language}" var="i3" />
<fmt:message key="cabinet.newpswd" bundle="${language}" var="i4" />
<fmt:message key="cabinet.pswd" bundle="${language}" var="i5" />
<fmt:message key="cabinet.upd" bundle="${language}" var="i51" />
<fmt:message key="cabinet.favteam" bundle="${language}" var="i6" />
<fmt:message key="cabinet.change" bundle="${language}" var="i7" />
<fmt:message key="cabinet.sport" bundle="${language}" var="i8" />
<fmt:message key="cabinet.country" bundle="${language}" var="i9" />

<fmt:message key="chooseteam.team" bundle="${language}" var="i10" />
<fmt:message key="chooseteam.header" bundle="${language}" var="i11" />
<fmt:message key="chooseteam.confirm" bundle="${language}" var="i12" />
<fmt:message key="chooseteam.notsure" bundle="${language}" var="i13" />

<fmt:message key="denied.den" bundle="${language}" var="i14" />
<fmt:message key="denied.desc" bundle="${language}" var="i15" />
<fmt:message key="denied.back" bundle="${language}" var="i16" />
<fmt:message key="league.league" bundle="${language}" var="i17" />
<fmt:message key="league.results" bundle="${language}" var="i18" />

<fmt:message key="login.main" bundle="${language}" var="i19" />
<fmt:message key="login.login" bundle="${language}" var="i20" />
<fmt:message key="login.password" bundle="${language}" var="i21" />
<fmt:message key="login.forgot" bundle="${language}" var="i22" />

<fmt:message key="menu.home" bundle="${language}" var="i23" />
<fmt:message key="menu.predicts" bundle="${language}" var="i24" />
<fmt:message key="menu.ratings" bundle="${language}" var="i25" />
<fmt:message key="menu.tables" bundle="${language}" var="i26" />
<fmt:message key="menu.profile" bundle="${language}" var="i27" />
<fmt:message key="menu.log" bundle="${language}" var="i271" />
<fmt:message key="menu.exit" bundle="${language}" var="i272" />


<fmt:message key="notlogd.in" bundle="${language}" var="i28" />
<fmt:message key="notlogd.up" bundle="${language}" var="i29" />

<fmt:message key="predict.main" bundle="${language}" var="i30" />
<fmt:message key="predict.for" bundle="${language}" var="i31" />
<fmt:message key="predict.date" bundle="${language}" var="i32" />
<fmt:message key="predict.home" bundle="${language}" var="i33" />
<fmt:message key="predict.away" bundle="${language}" var="i34" />
<fmt:message key="predict.your" bundle="${language}" var="i35" />
<fmt:message key="predict.cur" bundle="${language}" var="i36" />

<fmt:message key="ratings.main" bundle="${language}" var="i37" />
<fmt:message key="ratings.user" bundle="${language}" var="i38" />
<fmt:message key="ratings.points" bundle="${language}" var="i39" />
<fmt:message key="ratings.scores" bundle="${language}" var="i40" />
<fmt:message key="ratings.prev" bundle="${language}" var="i41" />

<fmt:message key="signup.main" bundle="${language}" var="i42" />
<fmt:message key="signup.login" bundle="${language}" var="i43" />
<fmt:message key="signup.pswd" bundle="${language}" var="i44" />
<fmt:message key="signup.pswdagn" bundle="${language}" var="i45" />
<fmt:message key="signup.email" bundle="${language}" var="i46" />
<fmt:message key="signup.country" bundle="${language}" var="i47" />
<fmt:message key="signup.up" bundle="${language}" var="i48" />

<fmt:message key="snc.fav" bundle="${language}" var="i49" />
<fmt:message key="snc.sport" bundle="${language}" var="i50" />
<fmt:message key="snc.choose" bundle="${language}" var="i51" />
<fmt:message key="snc.no" bundle="${language}" var="i52" />