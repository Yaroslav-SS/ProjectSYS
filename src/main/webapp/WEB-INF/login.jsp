<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/style.css">
    <title>Авторизация пользователя</title>
<body>

<main class="main">
    <h1 class="main-heading-title"> Авторизация пользователя
    </h1>
    <div class="beginning">
        <h2 title="Введите данные: логин — admin, пароль — 123, роль — Администратор">
            Введите логин, пароль и роль.
        </h2>
        <br>
        <form action="/login" method="post">
            <p>Логин:  </p>

            <input type="text" name = "login">

            <br>
            <br>
            <p>Пароль:  </p>

            <input type="text" name="password">
            <br>
            <br>
            <p>Роль: </p>
            <select name="role" >
                <option style="font-family: Sylfaen; font-size: 10pt;">Администратор</option>
                <option style="font-family: Sylfaen; font-size: 10pt;">Студент</option>

            </select>
            <br>
            <br>
            <br>
            <input type="submit" value=" войти">
            <c:if test="${message eq 1}">
                <h3>Неверные данные! Повторите ввод.</h3>
            </c:if>
        </form>


    </div>
</main>

</body>
</html>