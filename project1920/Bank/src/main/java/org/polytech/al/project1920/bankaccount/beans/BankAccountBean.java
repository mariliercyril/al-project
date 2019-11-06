package org.polytech.al.project1920.bankaccount.beans;

import org.polytech.al.project1920.bankaccount.model.BankAccountStorage;
import org.polytech.al.project1920.bankaccount.model.BankAccountStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountBean {
    private final BankAccountStorageDB bankAccountStorageDB;

    @Autowired
    public BankAccountBean(BankAccountStorageDB bankAccountStorageDB) {
        this.bankAccountStorageDB = bankAccountStorageDB;
    }

    public void createAccount(String userId) {
        BankAccountStorage bankAccountStorage = new BankAccountStorage(userId);
        bankAccountStorageDB.save(bankAccountStorage);

        List<BankAccountStorage> bankAccountStorages = bankAccountStorageDB.findAll();

        for (BankAccountStorage bas : bankAccountStorages) {
            System.out.println(bas.getAmount());
            System.out.println(bas.getUserID());
        }
    }

    public List<Float> getAmounts(String userId) {
        List<BankAccountStorage> bankAccountStorages = bankAccountStorageDB.getBankAccountStoragesByUserID(userId);
        List<Float> amounts = new ArrayList<>();
        for (BankAccountStorage bankAccountStorage : bankAccountStorages) {
            amounts.add(bankAccountStorage.getAmount());
        }
        return amounts;
    }

    public boolean canPayTransfert(String senderAccountId, double amount) {
        return true;
    }

    public boolean canPayCard(String senderAccountId, double amount) {
        return true;
    }
}