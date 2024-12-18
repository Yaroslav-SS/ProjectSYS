<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления студентами и их успеваемостью</title>
    <link rel="stylesheet" href="../resources/css/styleStudentsProgress.css">
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
            <a href="/login" >Logout</a>
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
                    Отображена успеваемость для следующего студента:
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table class="table-main-info table-one-student">
                <tbody>
                <tr>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Группа</th>
                    <th>Дата поступления</th>
                </tr>
                <tr>
                    <td>${student.surname}</td>
                    <td>${student.name}</td>
                    <td>${student.group}</td>
                    <td><fmt:formatDate value="${student.date}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>



<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div class="display-flex start for-mobile-display-block">
                <div class="column-20"></div>
                <div>
                    <table class="table-main-info table-student-progress">
                        <tbody><tr>
                            <th>Дисциплина</th>
                            <th>Оценка</th>
                        </tr>
                        <c:forEach items="${marks}" var="mark">

                        <tr>
                            <td>${mark.discipline.discipline}</td>
                            <td>${mark.mark}</td>
                        </tr>
                        </c:forEach>

                        </tbody></table>
                </div>
            </div>


            <div class="col-lg-6">
                <form method="get" action="/student-progress" >
                    <input type="hidden" name="idStudProgress" value="${student.id}">
                    <div class="div-student-progress-select-semestr">
                        <div class="display-flex start">
                            <label>Выбрать семестр</label>
                            <div class="select">
                                <select name="idSelectedTerm">
                       <c:forEach items="${terms}" var="t">
                           <c:choose>
                               <c:when test="${t.id eq idSelectedTerm}">
                                   <option selected value="${t.id}"> ${t.term}</option>
                               </c:when>
                               <c:otherwise>
                                   <option value="${t.id}"> ${t.term}</option>
                               </c:otherwise>
                           </c:choose>

                       </c:forEach>

                                </select>
                            </div>

                            <input type="submit" value="Выбрать">
                        </div>

                        <c:choose>
                            <c:when test="${not empty averageMark}">
                                <label name="averageMark">Средняя оценка за семестр: ${averageMark}</label>
                            </c:when>
                            <c:otherwise>
                                <label>Средняя оценка за семестр: нет оценок</label>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>