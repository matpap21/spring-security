<%@page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="../head.jspf" %>
<body> <%-- dodajemy pod body fragment kodu nav.jspf--%>
<%@include file="../nav.jspf" %>
<div class="container m-6">
    <h2>Lista osob</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Pensja</th>
            <th>Pesel</th>
            <th>Dostepnosc</th>

        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="personMap" scope="request" type="java.util.List<pl.sda.springproject2.model.Person>"/>
        <c:forEach items="${personMap}" var="person">
            <tr>
                <td>
                        ${person.firstName}
                </td>
                <td>
                        ${person.lastName}
                </td>
                <td>
                        ${person.salary}
                </td>
                <td>
                        ${person.pesel}
                </td>

                <td>
                        ${person.available}
                </td>
                <td>

                    <c:if test="${person.available}">
                        <input class="form-check-input" type="checkbox" checked disabled>
                    </c:if>
                    <c:if test="${!person.available}">
                        <form action="/person/available" method="post">
                            <input type="hidden" name="id" value="${person.pesel}">
                            <input class="form-check-input" type="checkbox" name="completed" required>
                            <button class="btn btn-danger" type="submit">Zapisz osobe</button>
                        </form>
                    </c:if>
                </td>
                <td>
                        ${person.created}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/person/add">Formularz nowej osoby</a>
</div>
</body>
</html>