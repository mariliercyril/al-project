package org.polytech.al.project1920.bankaccount.services;

import java.util.List;

public interface IManageUser {
    List<Float> getAmounts(String userId);

    void createAccount(String userId);
}
