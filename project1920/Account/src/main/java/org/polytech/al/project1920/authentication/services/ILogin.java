package org.polytech.al.project1920.authentication.services;

public interface ILogin {
    public boolean login(String userId, String password);

    public boolean createAccount(String userId, String password);
}
