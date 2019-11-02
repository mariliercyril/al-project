package org.polytech.al.project1920.authentication.beans;

import org.polytech.al.project1920.authentication.model.AuthenticationStorage;
import org.polytech.al.project1920.authentication.model.AuthenticationStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationBean {
    private final AuthenticationStorageDB authenticationStorageDB;

    @Autowired
    AuthenticationBean(AuthenticationStorageDB authenticationStorageDB) {
        this.authenticationStorageDB = authenticationStorageDB;
    }

    public boolean login(String userId, String password) {
        //TODO verify that the password is ok
        System.out.println("User with ID " + userId + " just logged in");
        return true;
    }

    public boolean createAccount(String userId, String password) {
        //TODO store the new account

        AuthenticationStorage authenticationStorage = new AuthenticationStorage(userId, password);
        if (!authenticationStorageDB.findAuthenticationStorageByUserId(userId).isPresent()) {
            authenticationStorageDB.save(authenticationStorage);
            System.out.println("Created account for user account with ID " + userId);

            List<AuthenticationStorage> authenticationStorages = authenticationStorageDB.findAll();

            for (AuthenticationStorage authenticationStorage1 : authenticationStorages) {
                System.out.println(authenticationStorage1.getId());
                System.out.println(authenticationStorage1.getUserId());
                System.out.println(authenticationStorage1.getPassword());
            }
            return true;
        } else {
            System.out.println("Account with ID " + userId + " already exists, can't create account !");
            return false;
        }
    }
}
