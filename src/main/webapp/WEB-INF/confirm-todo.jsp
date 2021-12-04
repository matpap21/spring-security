<jsp:useBean id="todo" scope="request" type="pl.sda.springproject2.model.ToDo"/>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<%@include file="head.jspf"%>
<body>
<%@include file="nav.jspf"%>
<%--    Dodaj wyświetlenie pozostałych pól klasy Todo--%>
<h1>Ok, dodano nowe zadanie</h1>
    <p>Tytul: ${todo.title}</p>
    <p>Id zadania: ${todo.id}</p>
    <p>Data dodania zadania: ${todo.created}</p>
    <p>Czas na wykonanie zadania: ${todo.deadline}</p>
    <p>Osoba odpowiedzialna: ${todo.person}</p>
    <p>Status wykonywanego zadania: ${todo.completed}</p>

<a href="${pageContext.request.contextPath}/">Home"</a>
<a href="${pageContext.request.contextPath}/todo/add">Dodaj nastepne zadanie"</a>
</body>
</html>