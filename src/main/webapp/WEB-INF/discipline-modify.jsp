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
    <link rel="stylesheet" href="../resources/css/styleDicsMod.css">
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
    <div class="row">
        <div class="col-lg-4">
            <div class="margin-top">
                <a class="a-na-glavnuu" href="/index.jsp">На главную</a>
                <a class="a-na-glavnuu" href="/discipline">Назад</a>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="margin-top">
                <div class="main-title-page">
                    Чтобы модифицировать дисциплину введите новое значение и нажмите кнопку "Применить".
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start">
                <div class="column-20"></div>

                <form action="/discipline-modify" method="post">

                    <input type="hidden" name="id" value="${id}">

                    <div class="div-for-student-modifing div-class-for-button-error">

                        <div class="display-flex">
                            <label>Название</label>

                            <input name="modifiedDiscipline" type="text" value="${disciplineName}"></div>
                        <div class="display-flex button">
                            <input type="submit" value="Применить"></div>
                    </div>
                    <c:if test="${error eq '1'}">
                        <p class="color-text-error">Поле должно быть заполнено!</p>
                    </c:if>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>