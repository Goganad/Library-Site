package beans;

import java.time.LocalDateTime;

public class Order {

    public enum Type {
        ABONEMENT,
        READING_ROOM
    }

    public final Integer id;
    public final Integer idBook;
    public final Integer idUser;
    public final LocalDateTime date;
    public final Type type;
    public final boolean state;

    public Order(Integer id, Integer idBook, Integer idUser, LocalDateTime date, Type type, boolean state) {
        this.id = id;
        this.idBook = idBook;
        this.idUser = idUser;
        this.date = date;
        this.type = type;
        this.state = state;
    }
}