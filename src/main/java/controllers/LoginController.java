package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if (DBManager.canLogin(login,password,role)){       // если верно ввели данные
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("login", login);
        resp.sendRedirect("/");
        } else {// если ошиблись где то
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
        }
    }
}
