package controllers;

import db.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Term> terms = DBManager.getAllActiveTerms(); // подключиться к базе и передать информацию
        req.setAttribute("terms", terms); // посылка, название посылки и объект который передаем(коллекцию студентов)
        req.setAttribute("selectedTerm", terms.get(0));
        ArrayList<Discipline> disciplinesByTerm = DBManager.getAllActivDisciplinesByTerm(terms.get(0).getId());
        req.setAttribute("allDisciplinesByTerm", disciplinesByTerm);

        req.getRequestDispatcher("WEB-INF/terms.jsp").forward(req, resp); // метод форвард это и есть перенаправить
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String idTermDelete = req.getParameter("idTermDelete"); //s - имя hidden
        if (idTermDelete != null) {
            DBManager.deleteTerm(idTermDelete);
            resp.sendRedirect("/terms");
        } else {
            List<Term> terms = DBManager.getAllActiveTerms();
            String termId = req.getParameter("selectedTerm");
            int selectedId = Integer.parseInt(termId);
            for (Term s : terms) {
                if (s.getId() == selectedId) {
                    req.setAttribute("terms", terms);
                    req.setAttribute("selectedTerm", s);
                    ArrayList<Discipline> disciplinesByTerm = DBManager.getAllActivDisciplinesByTerm(selectedId);
                    req.setAttribute("allDisciplinesByTerm", disciplinesByTerm);
                    req.getRequestDispatcher("WEB-INF/terms.jsp").forward(req, resp);
                }
            }
        }
    }
}




// Достаем все активные семестры ( можно только названия и ид) и отправляем на отображение
// достаем список дисциплин выбранного семестра и передаем на отображение