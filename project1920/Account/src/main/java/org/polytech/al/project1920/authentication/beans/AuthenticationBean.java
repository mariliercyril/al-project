package org.polytech.al.project1920.authentication.beans;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationBean {

    public boolean login(String accountId, String password) {
        //TODO verify that the password is ok
        System.out.println("Login for user account with ID " + accountId);
        return true;
    }

    public boolean createAccount(String accountId, String password) {
        //TODO store the new account
        System.out.println("Created account for user account with ID " + accountId);
        return true;
    }
}
