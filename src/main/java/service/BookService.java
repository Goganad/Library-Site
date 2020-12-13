package service;

import beans.Book;
import dao.BookDAO;

import java.util.List;

public class BookService {
    public static List<Book> getAll() {
        try {
            return new BookDAO().getBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Book byID(int id) {
        try {
            return new BookDAO().getBookByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Book byTitle(String title) {
        try {
            return new BookDAO().getBookByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
