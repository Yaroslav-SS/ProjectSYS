package controllers;


import db.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name = "DisciplineController", urlPatterns = "/discipline")
public class DisciplineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplines = DBManager.getAllActiveDiscipline(); // подключиться к базе и передать информацию
        req.setAttribute("disciplines",disciplines ); // посылка, название посылки и объект который передаем(коллекцию студентов)
      req.getRequestDispatcher("WEB-INF/discipline.jsp").forward(req, resp); // метод форвард это и есть перенаправить
    }
}
