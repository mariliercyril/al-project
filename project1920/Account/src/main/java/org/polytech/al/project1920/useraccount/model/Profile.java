package org.polytech.al.project1920.useraccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profile")

public class Profile {
    @Id
    private String id;
    private int age;
    private int money;

    public Profile() {
    }

    public Profile(int age, int money) {
        this.age = age;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
