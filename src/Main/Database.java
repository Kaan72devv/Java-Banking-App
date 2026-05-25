package Main;

import java.util.ArrayList;

public class Database {

    ArrayList<User> users = new ArrayList<User>();

    public Database() {

        users.add(new User("admin", "root", 1000));
        users.add(new User("user", "1234", 500));
    }

    public User Login(String username, String password) {

        for (User user : users) {

            if (user.username.equals(username) && user.password.equals(password)) {

                return user;
            }
        }

        return null;
    }
}
