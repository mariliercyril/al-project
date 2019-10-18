package org.polytech.al.project1920.bankaccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankAccountStorageDB")
public class BankAccountStorage {
    @Id
    private String id;
    private String userID;

    public BankAccountStorage(String userID){
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
