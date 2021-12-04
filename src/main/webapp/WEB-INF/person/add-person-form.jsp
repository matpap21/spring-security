<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<html>
<%@include file="../head.jspf"%>
<body>
<%@include file="../nav.jspf"%>
<div class="container m-6">
    <h2 class="lead-2">Dodaj nowa Osoba</h2>
<form method="post">
    <div class="mb-3">
    <label for="firstName"> Imie</label><br>
    <input type="text" name="firstname" id="firstname"/><br>

    <label for="lastName"> Nazwisko</label><br>
    <input type="text" name="lastName" id="lastName"><br>

    <label for="salary"> Pensja</label><br>
    <input type="number" name="salary" id="salary"><br>

    <label for="pesel"> Pesel</label><br>
    <input type="text" name="pesel" id="pesel"><br>


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