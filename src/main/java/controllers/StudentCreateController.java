package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentCreateController", urlPatterns = "/students-create")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/students-create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (surname.isEmpty() || name.isEmpty() || group.isEmpty() || date.isEmpty()) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("WEB-INF/students-create.jsp").forward(req, resp);
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

        DBManager.createStudent(surname, name, group, dateStrToBD);

        resp.sendRedirect("/students");


    }
}
