package org.polytech.al.project1920.useraccount.beans;

import org.polytech.al.project1920.useraccount.model.User;
import org.polytech.al.project1920.useraccount.model.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBean {

    private final
    UserDB userDB;

    @Autowired
    public UserBean(UserDB userDB) {
        this.userDB = userDB;
        setDB();
    }

    public User getUser(String userId) {
        return userDB.findById(userId).orElse(userDB.findAll().get(0));
    }

    public List<User> getUsers() {
        return userDB.findAll();
    }

    private void setDB() {
        if (userDB.findAll().size() == 0) {
            userDB.save(new User(20, 1000, "User 1"));
            userDB.save(new User(45, 66666, "User 2"));
            userDB.save(new User(14, 200, "User 3"));
        }
    }
}
