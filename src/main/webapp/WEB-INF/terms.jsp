<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../resources/js/function.js"></script>
    <title>Система управления студентами и их успеваемостью</title>
    <link rel="stylesheet" href="../resources/css/styleTermList.css">
</head>
<Header>
    <h2 >
        Система управления студентами и их успеваемостью
    </h2>
</Header>
<body>
<br><br><br>
<div class="logout">
    <c:choose>
    <c:when test="${role eq null}">
        <a href="/login">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/logout">Logout, ${login}</a>
    </c:otherwise>
</c:choose>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-2">
            <div class="display-flex start padding-top-10">
                <div class="column-20">
                    <a class="a-na-glavnuu" href="/index.jsp">На главную</a>
                </div>
            </div>
        </div>
        <div class="col-lg-10">
            <div class="div-student-progress-select-semestr">
                <div class="display-flex start">
                    <form action="/terms" method="post">
                        <label>Выбрать семестр</label>
                        <div class="select">
                            <select name="selectedTerm">

                                <option selected hidden value="${selectedTerm.id}">${selectedTerm.term}</option>

                                <c:forEach items="${terms}" var="terms">
                                    <option value="${terms.id}">${terms.term}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <input class="button" type="submit" value="Выбрать">
                    </form>
                </div>
                <label name="selectedDuration">Длительность семестра: ${selectedTerm.duration}</label>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start" id="div-title-page">
                <div class="column-20">
                </div>
                <div class="main-title-page">
                    Список дисциплин семестра
                </div>
            </div>


            <div id="disciplina-list" class="display-flex start for-mobile-display-block">
                <div class="column-20"></div>
                <div>
                    <table class="table-main-info table-student-progress">
                        <tbody>
                        <tr>
                            <th>Наименование дисциплины</th>
                        </tr>
                        <c:forEach items="${allDisciplinesByTerm}" var="dis">  <%--items - элементы по которым проходимся, вставляем название посылки, Var - название объекта*/
--%>
                            <tr>
                                <td>${dis.discipline}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="div-student-progress-select-semestr">
                    <div class=" mobile-div">
                        <form action="/terms-create" method="get">
                            <c:if test="${role eq 'Администратор'}">
                                <div><input class="big-big-button" type="submit" value="Создать семестр..."></div>
                            </c:if>

                        </form>
                        <form action="/terms-modify" method="get">
                            <input type="hidden" name="idModifyTerm" id="idModifyTerm" value="${selectedTerm.id}">
                            <c:if test="${role eq 'Администратор'}">
                            <div><input type="submit" class="big-big-button" value="Модифицировать выбранный семестр..."></div>
                            </c:if>
                        </form>

                        <form action="/terms" method="post" id ="deleteTermForm">
                            <input type="hidden" name="idTermDelete" id="idTermDel" value="${selectedTerm.id}">
                            <c:if test="${role eq 'Администратор'}">
                            <div><input class="big-big-button" type="submit" value="Удалить выбранный семестр..." onclick="deleteTerms()"></div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




</body>
</html>