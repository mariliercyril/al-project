package org.polytech.al.project1920.useraccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")

public class User {
    @Id
    private String id;
    private String userId;
    private int age;
    private int money;
    private String password;

    public User() {
    }

    public User(int age, int money, String userId, String password) {
        this.age = age;
        this.money = money;
        this.userId = userId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
