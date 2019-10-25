package org.polytech.al.project1920.useraccount.services;

import org.polytech.al.project1920.useraccount.beans.UserBean;
import org.polytech.al.project1920.useraccount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExtractUserData implements IExtractUserData {

    private final
    UserBean userBean;

    @Autowired
    public ExtractUserData(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    @RequestMapping(value = "/retrieveUsers", method = RequestMethod.GET)
    public List<User> retrieveUsers() {
        System.out.println("Retrieving all users");
        return userBean.getUsers();
    }

    @Override
    @RequestMapping(value = "/retrieveUser", method = RequestMethod.GET)
    public User retrieveUser(@RequestParam String userId) {
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(userId);
        return userBean.getUser(userId);
    }
}
