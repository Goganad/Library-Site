package beans;

public class Book {

    public final Integer id;
    public final String title;
    public final String author;
    public final Integer pages;
    public final String publisher;
    public final Integer count;

    public Book(Integer id, String title, String author, Integer pages, String publisher, Integer count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
        this.count = count;
    }
}