package org.polytech.al.project1920.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AuthenticationStorageDB")
public class AuthenticationStorage {
    @Id
    private String id;
    private String userId;
    private String password;

    public AuthenticationStorage() {

    }

    public AuthenticationStorage(String id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
