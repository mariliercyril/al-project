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

    public boolean createAccount(String userId) {
        if(!bankAccountStorageDB.getBankAccountStorageByUserID(userId).isPresent()) {
            BankAccountStorage bankAccountStorage = new BankAccountStorage(userId);
            bankAccountStorageDB.save(bankAccountStorage);

            System.out.println("Created bank account for user account with ID " + userId);

            List<BankAccountStorage> bankAccountStorages = bankAccountStorageDB.findAll();

            for (BankAccountStorage bas : bankAccountStorages) {
                System.out.println(bas.getAmount());
                System.out.println(bas.getUserID());
            }

            return true;
        }
        else {
            System.out.println("Bank account with user ID " + userId + " already exists, can't create account !");
            return false;
        }
    }

    public Float getAmount(String userId) {
        Optional<BankAccountStorage> bankAccountStorage = bankAccountStorageDB.getBankAccountStorageByUserID(userId);
        return bankAccountStorage.map(BankAccountStorage::getAmount).orElse((float) -1);
    }

    public boolean canPayTransfert(String senderAccountId, double amount) {
        return true;
    }

    public boolean canPayCard(String senderAccountId, double amount) {
        return true;
    }
}