
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<%@include file="head.jspf"%>
<body>
<%@include file="nav.jspf"%>
<div class="container m-6">
<h2 class="lead-2">Dodaj nowe Zadanie</h2>
<form method="post">
    <%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> <%-- dodajemy pod body fragment kodu nav.jspf // spring do kazdego widoku doda nam jawnie ten token (wstrzykuje go)--%>
    <div class="mb-3">
    <label for="title"> Tytul zadania</label>
    <input class="form-control" type="text" name="title" id="title"/><br>

    <label for="deadline"> Termin wykonania</label>
    <input class="form-control" type="date" name="deadline" id="deadline"><br>

    <label for="person"> Osoba odpowiedzialna</label>
    <input class="form-control" type="text" name="person" id="person" ><br>

    <button class="btn btn-primary" type="submit">Zapisz</button>
    <button class="btn btn-secondary" type="reset">Wyczysc</button>
    </div>
    <div class="mb-3">
        <button class="btn btn-primary" type="submit">Zapisz</button>
        <button class="btn btn-warning" type="reset">Wyczyść</button>
    </div>
</form>
</div>
</body>
</html>