<jsp:useBean id="person" scope="request" type="pl.sda.springproject2.model.Person"/>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<body>
<%--    Dodaj wyswietlenie pozostalych pol ToDo--%>
<h1> Dodano nowa osobe</h1>
<p>Imię: ${person.firstName}</p>
<p>Nazwisko: ${person.lastName}</p>
<p>Pensja: ${person.salary}</p>
<p>Pensja: ${person.pesel}</p>
<p>Pensja: ${person.available}</p>
<a href="${pageContext.request.contextPath}/person">Person"</a> <%-- --%>
<a href="${pageContext.request.contextPath}/person/add">Dodaj nastepna osobe"</a>
</body>
</html>