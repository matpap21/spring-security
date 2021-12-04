<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<%@include file="../head.jspf"%> <%-- wypenienie kodu z pliku jspf --%>
<body>
<%@include file="../nav.jspf"%>
<ul>
    <li>
        <a href="/person/add">Dodaj osobę</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/person/list">Lista osob</a>
    </li>
</ul>
</body>
</html>