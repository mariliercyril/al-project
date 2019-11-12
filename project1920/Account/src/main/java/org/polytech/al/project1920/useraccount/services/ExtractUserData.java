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
    @RequestMapping(value = "/retrieveusers", method = RequestMethod.GET)
    public List<User> retrieveUsers() {
        System.out.println("Retrieving all users");
        return userBean.getUsers();
    }

    @Override
    @RequestMapping(value = "/retrieveUser", method = RequestMethod.GET)
    public User retrieveUser(@RequestParam String userId) {
        System.out.println("Retrieved user for userId : " + userId);
        return userBean.getUserByUserId(userId);
    }

    @Override
    @RequestMapping(value = "/retrieveUserById", method = RequestMethod.GET)
    public User retrieveUserByMongoId(@RequestParam String id) {
        System.out.println("Retrieved user for mongo id : " + id);
        return userBean.getUserById(id);
    }

    @Override
    @RequestMapping(value = "/prettyDump", method = RequestMethod.GET)
    public void prettyDump() {
        userBean.prettyDump();
    }

    @RequestMapping(value = "/yo", method = RequestMethod.GET)
    public List<User> yo() {
        return userBean.getUsers();
    }
}
