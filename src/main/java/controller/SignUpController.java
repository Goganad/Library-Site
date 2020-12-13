package controller;

import beans.User;
import service.UserService;
import utilities.Hasher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.SignUpController")
public class SignUpController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("GET");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        User.Role role = User.Role.READER;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phash = password.isEmpty() ? "" : Hasher.SHA256(password);

        User user = UserService.register(name, surname, role, email, phash);
        if (user != null) {
            req.getSession().setAttribute("user", user);
        }

        resp.sendRedirect("/");
    }
}