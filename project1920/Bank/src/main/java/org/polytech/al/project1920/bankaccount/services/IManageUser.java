package org.polytech.al.project1920.bankaccount.services;

public interface IManageUser {
    Float getAmount(String userId);

    boolean createAccount(String userId);

    boolean addMoney(String userId, float amount);
}
