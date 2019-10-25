package org.polytech.al.project1920.authentication.services;

import org.polytech.al.project1920.authentication.beans.AuthenticationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginWebService implements ILogin {

    private AuthenticationBean authenticationBean;

    @Autowired
    public LoginWebService(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    @Override
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public boolean createAccount(@RequestParam String accountId, @RequestParam String password) {
        System.out.println("Created a new account in Authentication");
        return authenticationBean.createAccount(accountId, password);
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean login(@RequestParam String accountId, @RequestParam String password) {
        System.out.println("Login in Authentication");
        return authenticationBean.login(accountId, password);
    }
}