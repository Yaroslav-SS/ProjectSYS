package controllers;

import db.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="TermCreatingController", urlPatterns = "/terms-create")
public class TermCreatingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDiscipline();
        req.setAttribute("allDisciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/terms-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String duration = req.getParameter("duration");
        String[] disciplines = req.getParameterValues("disciplines");
        if(duration.equals("")){
            req.setAttribute("error", "1");
            ArrayList<Discipline> disciplines2 = DBManager.getAllActiveDiscipline();
            req.setAttribute("allDisciplines", disciplines2);
            req.getRequestDispatcher("WEB-INF/terms-create.jsp").forward(req, resp);
        }else{
            DBManager.createTerm(duration, disciplines);
            resp.sendRedirect("/terms");
        }
    }
}
