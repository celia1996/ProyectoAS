package database;

import java.util.ArrayList;

/**
 *
 * @author celia
 */
public class User {

    private String userName;
    private String password;
    private int id;

    public User(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<User> users = new ArrayList<User>() {
        {
            add(new User("Celia", "1234", 1));
            add(new User("Angelo", "1234", 2));
            add(new User("Cristina", "1234", 3));

        }
    };

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static User findUser(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

}
