<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления студентами и их успеваемостью</title>
    <link rel="stylesheet" href="../resources/css/style.css">
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
<div class="row">

    <div class="column">
        <a href="/terms">
            <h3>Семестры</h3>
        </a>
    </div>
    <div class="column">
        <a href="/discipline">
            <h3>Дисциплины</h3>
        </a>
    </div>
    <div class="column">
        <a href="/students">
            <h3>Студенты</h3>
        </a>
    </div>
</div>

</body>
</html>