package controller;

import javax.servlet.annotation.WebServlet;
import beans.Book;
import service.BookService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainReader")
public class ReaderController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = BookService.getAll();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Book> list = BookService.getAll();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
    }
}