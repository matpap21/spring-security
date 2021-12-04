<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<%@include file="head.jspf"%> <%-- wypenienie kodu z pliku jspf --%>
<body>
<%@include file="nav.jspf"%>

<h1> Hello from Hell</h1>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/todo/add">Formularz zadania do wykonania</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/todo/list">Lista zadan</a>
    </li>

</ul>
</body>
</html>