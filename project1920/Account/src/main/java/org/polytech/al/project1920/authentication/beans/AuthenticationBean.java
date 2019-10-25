package org.polytech.al.project1920.authentication.beans;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationBean {

    public boolean login(String userId, String password) {
        //TODO verify that the password is ok
        System.out.println("Login for user account with ID " + userId);
        return true;
    }

    public boolean createAccount(String userId, String password) {
        //TODO store the new account
        System.out.println("Created account for user account with ID " + userId);
        return true;
    }
}
