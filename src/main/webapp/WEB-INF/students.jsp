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
    <link rel="stylesheet" href="../resources/css/styleStudentsList.css">
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
            <a href="/login">Login</a>
        </c:when>
        <c:otherwise>
            <a href="/logout">Logout, ${login}</a>
        </c:otherwise>
    </c:choose>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start padding-top-10">
                <div class="column-20">
                    <a class="a-na-glavnuu" href="/">На главную</a>
                </div>


                <div class="student-list-div">
                    <div class="display-flex mobile-div">

                        <div>
                            <form action="/student-progress" method="get" id="studentProgressForm">
                                <input type="hidden" id="studentProgressHidden" name="idStudProgress">
                                <input type="submit" class="black-button big-button"
                                       value="Просмотреть успеваемость выбранных студентов" onclick="studentProgress()">
                            </form>
                        </div>

                        <div>
                            <form action="/students-create" method="get">
                                <c:if test="${role eq 'Администратор'}">
                                    <input type="submit" class="black-button small-button" value="Создать студента">
                                </c:if>
                            </form>

                        </div>
                    </div>

                    <div class="display-flex mobile-div">
                        <div>
                            <form action="/student-modify" method="get" id="selectedStudentIdForm">
                                <input type="hidden" id="selectedStudentIdHidden" name="idsToModify">
                                <c:if test="${role eq 'Администратор'}">
                                    <input type="submit" class="black-button big-button"
                                           value="Модифицировать выбранного студента" onclick="modifyStudent()">
                                </c:if>
                            </form>
                        </div>

                        <div>
                            <form action="/student-delete" method="post" id="deleteStudentForm">
                                <input type="hidden" id="deleteStudentHidden" name="idStudent">

                                <c:if test="${role eq 'Администратор'}">

                                    <input type="submit" class="black-button small-button"
                                           value="Удалить выбранных студентов" onclick="deleteStudents()">
                                </c:if>
                            </form>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start">

                <div class="student-list-page">
                    Список студентов
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="display-flex start">
                <div class="column-10"></div>
                <div class="column-100">
                    <table class="table-main-info">
                        <tbody>
                        <tr>
                            <th></th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Группа</th>
                            <th>Дата поступления</th>
                        </tr>

                        <c:forEach items="${students}" var="st">
                            <tr>
                                <td><input type="checkbox" id="1" name="idStudent" value="${st.id}"></td>
                                <td>${st.surname}</td>
                                <td>${st.name}</td>
                                <td>${st.group}</td>
                                <td><fmt:formatDate value="${st.date}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
