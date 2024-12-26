<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../resources/js/function.js"></script>
    <title>Система управления студентами и их успеваемостью</title>
    <link rel="stylesheet" href="../resources/css/styleStudentsMod.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <script>
        $(function() {
            $("#datepicker").datepicker({dateFormat:'dd/mm/yy'});
        });
    </script>
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
            <a href="/login" >Login</a>
        </c:when>
        <c:otherwise>
            <a href="/logout" >Logout, ${login}</a>
        </c:otherwise>
    </c:choose>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <div class="margin-top">
                <a class="a-na-glavnuu" href="/">На главную</a>
                <a class="a-na-glavnuu" href="/students">Назад</a>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="margin-top">
                <div class="main-title-page">
                    Для модификации, введите новые значения и нажмите кнопку "Изменить".
                </div>
            </div>
        </div>
    </div>
</div>



<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start">
                <form action="/student-modify" method="post">
                    <div CLASS="div-for-student-modifing">
                        <input type="hidden" name="idsToModify" value="${idsToModify}">
                        <div class="display-flex"><label>Фамилия</label><input name="surname" type="text" value="${student.surname}"></div>
                        <div class="display-flex"><label>Имя</label><input name="name" type="text" value="${student.name}"></div>
                        <div class="display-flex"><label>Группа</label><input name="group" type="text" value="${student.group}"></div>
                        <div class="display-flex"><label>Дата поступления</label><input name="date" type="text" value="${student.date}" id="datepicker"></div>
                        <div class="display-flex btn ">
                            <input type="submit" value="Изменить"/>
                        </div>
                        <c:if test="${message eq 1}">
                            <h2> Поля не должны быть пустыми </h2>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>