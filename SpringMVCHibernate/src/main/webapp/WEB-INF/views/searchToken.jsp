<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form class="form-wrapper" action="/searchSelectedTokens" method="post">

    <input type="text" id="search" name = "search" disabled  placeholder="Search for Math Concepts ..." required>

    <input type="submit" value="go" id="submit">

    <br><br><br>

    <c:if test="${fn:length(countMap) gt 0}">

        <c:forEach items="${countMap}" var="map">

            <h5>( ${map.key} - ${map.value} <input type="checkbox" name="searchKeys" value="${map.key}" checked> ) </h5>

        </c:forEach>

    </c:if>

</form>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">


</body>
</html>
