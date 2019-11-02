package org.polytech.al.project1920.authentication.beans;

import org.polytech.al.project1920.authentication.model.AuthenticationStorage;
import org.polytech.al.project1920.authentication.model.AuthenticationStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationBean {
    private final AuthenticationStorageDB authenticationStorageDB;

    @Autowired
    AuthenticationBean(AuthenticationStorageDB authenticationStorageDB) {
        this.authenticationStorageDB = authenticationStorageDB;
    }

    public boolean login(String userId, String password) {
        Optional<AuthenticationStorage> authenticationStorage = authenticationStorageDB.findAuthenticationStorageByUserId(userId);
        if (authenticationStorage.isPresent()) {
            if (authenticationStorage.get().getPassword().equals(password)) {
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

    public boolean createAccount(String userId, String password) {
        if (!authenticationStorageDB.findAuthenticationStorageByUserId(userId).isPresent()) {
            AuthenticationStorage authenticationStorage = new AuthenticationStorage(userId, password);
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
