package org.polytech.al.project1920.authentication.beans;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationBean {

    public boolean login(String accountId, String password) {
        System.out.println("Login for user account with ID" + accountId);
        return true;
    }
}
