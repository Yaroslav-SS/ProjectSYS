package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="StudentDeleteController",urlPatterns = "/student-delete")
public class StudentDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 достать ids(678)
        // 2 в базе студентов в базе поменять на 0
        // 3 перенаправляем на /students
        String idsStr = req.getParameter("idStudent");
        String[] ids = idsStr.split(" ");
        for (String id:ids) {
            DBManager.deleteStudent(id);
        }
        resp.sendRedirect("/students");
    }
}

