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
  <link rel="stylesheet" href="../resources/css/styleDiscCr.css">
</head>
<Header>
  <h2 >
    Система управления студентами и их успеваемостью
  </h2>
</Header>
<body>
<br><br><br>
<div class="logout">
  <a href="">Logout</a>
</div>
<div class="container">
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
          Для того что создать новую дисциплину заполните все поля и нажмите кнопку "Создать".
        </div>
      </div>
    </div>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <div id="discipline-creating" class="display-flex start">
        <div class="column-20"></div>

        <form action="/discipline-create" method="post">
          <div class="div-for-student-modifing div-class-for-button-error">
            <div class="display-flex"><label>Название</label>
              <input type="text" name="discipline" ></div>
            <div class="display-flex button">
              <input type="submit" value="Создать"/> </div>
          </div>
        </form>

      </div>
    </div>
  </div>
</div>


</body>
</html>