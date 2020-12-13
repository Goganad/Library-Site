package controller;

import beans.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainLibrarian")
public class LibrarianController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = BookService.getAll();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/mainLibrarian.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addBook = request.getParameter("addBook");

        if(addBook != null){
            getServletContext().getRequestDispatcher("/addBook.jsp").forward(request, response);
        }
        else {
            List<Book> list = BookService.getAll();
            request.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/mainLibrarian.jsp").forward(request, response);
        }
    }
}
