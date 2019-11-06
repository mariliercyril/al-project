package org.polytech.al.project1920.bankaccount.services;

public interface IManageUser {
    int getAmount(String userId);

    void createAccount(String userId);
}
