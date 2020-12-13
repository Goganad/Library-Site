package service;

import beans.User;
import dao.UserDAO;

public class UserService {
    public static User register(String name, String surname, User.Role role, String email, String passwordHash) {
        if(!name.isEmpty() && !surname.isEmpty() && !email.isEmpty() && !passwordHash.isEmpty()) {
            try {
                if(!(new UserDAO().isUserExists(email))) {
                    User user = new User(name, surname, role, email, passwordHash);
                    if (new UserDAO().addUser(user)) {
                        return user;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static User authorization (String email, String passwordHash) {
        try {
            User user = new UserDAO().getUserByEmail(email);
            if (user != null && user.passwordHash.equals(passwordHash)) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
