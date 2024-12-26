<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Система управления студентами и их успеваемостью</title>
  <link rel="stylesheet" href="../resources/css/styleStudentsCr.css">

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
  </c:choose> <a href="">Logout</a>
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
          Для создания студента заполните все поля и нажмите кнопку "Создать".
        </div>
      </div>
    </div>
  </div>
</div>


<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <form action="/students-create" method="post">
        <div class="div-for-student-modifing div-class-for-button-error">
          <div class="display-flex"><label>Фамилия</label><input name="surname" type="text"></div>
          <div class="display-flex"><label>Имя</label><input name="name" type="text"></div>
          <div class="display-flex"><label>Группа</label><input name="group" type="text"></div>
          <div class="display-flex"><label>Дата поступления</label><input name="date" type="text" id="datepicker"></div>
          <div class="display-flex btn "><input type="submit" value="Создать"/>
          </div>
          <c:if test="${message eq 1}">
          <h2> Поля не должны быть пустыми </h2>
            </c:if>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>