package org.polytech.al.project1920.bankaccount.beans;

import org.polytech.al.project1920.bankaccount.model.BankAccountStorage;
import org.polytech.al.project1920.bankaccount.model.BankAccountStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public int getAmount(String userId) {
        Optional<BankAccountStorage> bankAccountStorage = bankAccountStorageDB.getBankAccountStorageByUserID(userId);
        return bankAccountStorage.map(BankAccountStorage::getAmount).orElse(-1);
    }

    public boolean canPayTransfert(String senderAccountId, double amount) {
        return true;
    }

    public boolean canPayCard(String senderAccountId, double amount) {
        return true;
    }
}