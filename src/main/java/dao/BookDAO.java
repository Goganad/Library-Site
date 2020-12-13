package dao;

import beans.Book;
import utilities.SetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public Book getBookByID(int id) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book WHERE id LIKE ?");
            query.setString(1, Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _title = result.getString(2);
                String _author = result.getString(3);
                int _pages = result.getInt(4);
                String _publisher = result.getString(5);
                int _count = result.getInt(6);
                return new Book(_id, _title, _author, _pages, _publisher, _count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Book getBookByTitle(String title) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book WHERE title LIKE ?");
            query.setString(1, title);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _title = result.getString(2);
                String _author = result.getString(3);
                int _pages = result.getInt(4);
                String _publisher = result.getString(5);
                int _count = result.getInt(6);
                return new Book(_id, _title, _author, _pages, _publisher, _count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooks() throws Exception {
        Connection connection = SetConnection.connect();

        try {
            List<Book> books = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM book");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _title = result.getString(2);
                String _author = result.getString(3);
                int _pages = result.getInt(4);
                String _publisher = result.getString(5);
                int _count = result.getInt(6);
                books.add(new Book(_id, _title, _author, _pages, _publisher, _count));
            }

            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addBook(Book book) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement addBookQuery = connection.prepareStatement("INSERT INTO book (title, author, pages, publisher, count) VALUES (?, ?, ?, ?, ?)");
            addBookQuery.setString(1, book.title);
            addBookQuery.setString(2, book.author);
            addBookQuery.setInt(3, book.pages);
            addBookQuery.setString(4, book.publisher);
            addBookQuery.setInt(5, book.pages);
            addBookQuery.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isBookExists(String title) throws Exception {
        return getBookByTitle(title) != null;
    }
}
