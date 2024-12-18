package controllers;

import db.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//
//        if (id == null || id.isEmpty()) {
//            resp.sendRedirect("/students");
//            return;
//        }
//        req.setAttribute("id", id);
//        ArrayList<Student> students = (ArrayList<Student>) DBManager.getAllActiveStudents();
//        for (Student student : students) {
//            if (student.getId() == Integer.parseInt(id)) {
//                req.setAttribute("selectStudent", student);
//                req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
//                return;
//            }
//
//        }
//        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idsToModify = req.getParameter("idsToModify");

        // Отладочная информация
        System.out.println("Полученный параметр id: " + idsToModify);
        System.out.println("Запрос URI: " + req.getRequestURI());
        System.out.println("Параметры запроса: " + req.getQueryString());

        if (idsToModify == null || idsToModify.isEmpty()) {
            System.out.println("Параметр id отсутствует или пустой. Перенаправляем на /students.");
            resp.sendRedirect("/students");
            return;
        }

        req.setAttribute("idM", idsToModify);
        List<Student> students = DBManager.getAllActiveStudents();
        for (Student student : students) {
            if (student.getId() == Integer.parseInt(idsToModify)) {
                req.setAttribute("student", student);  //+s
                req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
                return;
            }
        }

        System.out.println("Студент с id " + idsToModify + " не найден.");
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idsToModify");
        
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (surname.isEmpty() || name.isEmpty() || group.isEmpty() || date.isEmpty()) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
            return;
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateFromUser;
        try {
            dateFromUser = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatToDataBase = new SimpleDateFormat("yyyy-MM-dd");
        String dateStrToBD = formatToDataBase.format(dateFromUser);

        DBManager.modifyStudent(surname, name, group, dateStrToBD,id);

        resp.sendRedirect("/students");

    }
}
