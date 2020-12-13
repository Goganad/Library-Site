package beans;

public class User {

    public enum Role{
        LIBRARIAN,
        READER
    }

    public final Integer id;
    public final String name;
    public final String surname;
    public final Role role;
    public final String email;
    public final String passwordHash;


    public User(Integer id, String name, String surname, Role role, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User(String name, String surname, Role role, String email, String passwordHash) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}