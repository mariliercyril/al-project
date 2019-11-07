package org.polytech.al.project1920.authentication.beans;

import org.polytech.al.project1920.useraccount.model.User;
import org.polytech.al.project1920.useraccount.model.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationBean {
    private final UserDB userDB;

    @Autowired
    AuthenticationBean(UserDB userDB) {
        this.userDB = userDB;
    }

    public boolean login(String userId, String password) {
        Optional<User> user = userDB.findUserByUserId(userId);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                System.out.println("User with ID " + userId + " just logged in");
                return true;
            } else {
                System.out.println("Wrong password for account with ID " + userId + ", can't login !");
                return false;
            }
        } else {
            System.out.println("Account with ID " + userId + " doesn't exist, can't login !");
            return false;
        }
    }

    public boolean createAccount(String userId, String password, int age) {
        if (!userDB.findUserByUserId(userId).isPresent()) {
            User User = new User(age, 0, userId, password);
            userDB.save(User);
            System.out.println("Created account for user account with ID " + userId);

            return true;
        } else {
            System.out.println("Account with ID " + userId + " already exists, can't create account !");
            return false;
        }
    }
}
