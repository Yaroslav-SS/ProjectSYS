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
    <title>Дисциплины</title>
    <link rel="stylesheet" href="../resources/css/styleDisc.css">
</head>
<Header>
    <h2>
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
        <div class="col-lg-12">
            <div class="display-flex padding-top-10">
                <div class="column-20">
                    <a class="a-na-glavnuu" href="/index.jsp">На главную</a>
                </div>
                <div class="main-title-page">
                    Список дисциплин
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div id="disciplina-list" class="display-flex start for-mobile-display-block">
                <div class="column-20"></div>
                <div>
                    <table class="table-main-info table-student-progress">
                        <tbody>
                        <tr>
                            <c:if test="${role eq 'Администратор'}">
                             <th></th>
                            </c:if>
                            <th>Наименование дисциплины</th>
                        </tr>
                        <c:forEach items="${disciplines}" var="dis">  <%--items - элементы по которым проходимся, вставляем название посылки, Var - название объекта*/
--%>
                            <tr>
                                <c:if test="${role eq 'Администратор'}">
                                <td><input type="checkbox"  name="idDiscipline" id="" value="${dis.id}"></td>
                                </c:if>
                                <td>${dis.discipline}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-6">
                    <div class="div-student-progress-select-semestr">
                        <div class="mobile-div">
                            <div>
                                <form action="/discipline-create" method="get">
                                    <c:if test="${role eq 'Администратор'}">
                                    <input class="big-big-button" type="submit" value="Создать дисциплину...">
                                    </c:if>
                                </form>
                            </div>
                            <div>
                                <form action="/discipline-modify" method="get" id="discipline-modify-form">
                                    <input type="hidden" name="disc-mod-name" id="modifyId">

                                    <c:if test="${role eq 'Администратор'}">
                                    <input type="submit" class="big-big-button"
                                           value="Модифицировать выбранную дисциплину..." onclick="modifyDiscipline()">
                                    </c:if>
                                </form>
                            </div>

                            <c:if test="${role eq 'Администратор'}">
                            <div><input class="big-big-button" type="submit" value="Удалить выбранную дисциплину..."
                                        onclick="deleteDiscipline()"></div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<form action="/discipline-delete" method="post" id="deleteDisciplineForm">
    <input type="hidden" id="deleteDisciplineHidden" name="idDiscipline">

</form>


</body>
</html>