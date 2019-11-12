package org.polytech.al.project1920.bankaccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankAccountStorageDB")
public class BankAccountStorage {
    @Id
    private String id;
    private String userID;
    private float amount;

    public BankAccountStorage() {
    }

    public BankAccountStorage(String userID) {
        this.userID = userID;
        this.amount = 0;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void addAmount(float amount) {
        this.amount += amount;
    }

    public void removeAmount(float amount) {
        this.amount -= amount;
    }
}
