<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления студентами и их успеваемостью</title>
    <link rel="stylesheet" href="../resources/css/styleTermCr.css">
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
            <a href="/login">Login</a>
        </c:when>
        <c:otherwise>
            <a href="/logout">Logout, ${login}</a>
        </c:otherwise>
    </c:choose>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <div class="margin-top">
                <a class="a-na-glavnuu" href="/index.jsp">На главную</a>
                <a class="a-na-glavnuu" href="/terms">Назад</a>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="margin-top">
                <div class="main-title-page">
                    Для создания семестра заполните следующие данные и нажмите кнопку "Создать".
                </div>
            </div>
        </div>
    </div>
</div>


<form action="/terms-create" method="post">
    <div id="discipline-creating" class="display-flex start">
        <div class="column-20"></div>
        <div class="div-for-student-modifing div-for-student-page-new div-class-for-button-error">
            <div class="display-flex"><label>Длительность (в неделях)</label><input name="duration" type="text"></div>
            <div class="display-flex"><label>Дисциплины в семестре</label><select name="disciplines" multiple="" size="8">

                <c:forEach items="${allDisciplines}" var="disciplines">
                    <option>${disciplines.discipline}</option>
                </c:forEach>

            </select>
            </div>

            <div class="display-flex" id="button-create-term">
                <input type="submit" value="Создать">
            </div>
        </div>
    </div>
</form>

</body>
</html>