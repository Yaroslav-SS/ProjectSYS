package controllers;

import db.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")

public class StudentProgressController extends HttpServlet {

    // срабатывает на двух кнопках, при нажати на кнопку выбрать и кнопку посмотреть успеваемость выбранного студента
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 получаем id студента из hidden
        // 2 достаем с БД студента и передаем его на отображение
        // 3 достаем активные семестры название и id  и отправить а отобр
        // 4 Ожидаем от пользователя выбранный семестр и если его нет то выбранным является первым из списка семестров и отправляем его на отображ
        // 5 Достаем коллекцию оценок и передаем ее на отображение
        // 6 высчитать средний балл и отправить его на отображение

        // достали ид выбранного студента
        String idStudent = req.getParameter("idStudProgress");
        Student student = DBManager.getStudentById(idStudent);
        req.setAttribute("student", student);

        List<Term> terms = DBManager.getAllActiveTerms();
        req.setAttribute("terms", terms);


        // этот параметр мы будем передавать , если была нажата кнопка Выбрать
        String idSelectedTerm = req.getParameter("idSelectedTerm"); // null либо ""

        if (idSelectedTerm == null || idSelectedTerm.isEmpty()) { // значит перешли со страницы студенты
            if (terms.size() > 0) {
            idSelectedTerm = terms.get(0).getId() + "";

        }
        }
        req.setAttribute("idSelectedTerm", idSelectedTerm);

        List<Mark> marks = DBManager.getMarksByStudentAndTerm(idStudent, idSelectedTerm);
        req.setAttribute("marks", marks);

        String avgMark = DBManager.getAvgMark(idStudent, idSelectedTerm);
        req.setAttribute("averageMark", avgMark);


        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req,resp);

    }
}
