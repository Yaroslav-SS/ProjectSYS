package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineDeleteController", urlPatterns = "/discipline-delete")
public class DisciplineDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idsDis = req.getParameter("idDiscipline");
        String[] ids = idsDis.split(" ");
        for (String id:ids) {
            DBManager.deleteDiscipline(id);
        }
        resp.sendRedirect("/discipline");
    }
}
