package org.polytech.al.project1920.bankaccount.beans;

import org.polytech.al.project1920.bankaccount.model.BankAccountStorage;
import org.polytech.al.project1920.bankaccount.model.BankAccountStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankAccountBean {
    private final BankAccountStorageDB bankAccountStorageDB;

    @Autowired
    public BankAccountBean(BankAccountStorageDB bankAccountStorageDB) {
        this.bankAccountStorageDB = bankAccountStorageDB;
    }

    public boolean createAccount(String userId) {
        if (!bankAccountStorageDB.getBankAccountStorageByUserID(userId).isPresent()) {
            BankAccountStorage bankAccountStorage = new BankAccountStorage(userId);
            bankAccountStorageDB.save(bankAccountStorage);

            System.out.println("Created bank account for user account with ID " + userId);
//
//            List<BankAccountStorage> bankAccountStorages = bankAccountStorageDB.findAll();
//
//            for (BankAccountStorage bas : bankAccountStorages) {
//                System.out.println(bas.getAmount());
//                System.out.println(bas.getUserID());
//            }

            return true;
        } else {
            System.out.println("Bank account with user ID " + userId + " already exists, can't create account !");
            return false;
        }
    }

    public Float getAmount(String userId) {
        Optional<BankAccountStorage> bankAccountStorage = bankAccountStorageDB.getBankAccountStorageByUserID(userId);
        return bankAccountStorage.map(BankAccountStorage::getAmount).orElse((float) -1);
    }

    public boolean canPay(String senderId, float amount) {
        Optional<BankAccountStorage> bankAccountStorage = bankAccountStorageDB.getBankAccountStorageByUserID(senderId);
        return bankAccountStorage.filter(accountStorage -> accountStorage.getAmount() >= amount).isPresent();
    }

    public void pay(String senderId, String receiverId, float amount) {
        Optional<BankAccountStorage> senderAccount = bankAccountStorageDB.getBankAccountStorageByUserID(senderId);
        Optional<BankAccountStorage> receiverAccount = bankAccountStorageDB.getBankAccountStorageByUserID(receiverId);

        if (!senderAccount.isPresent() || !receiverAccount.isPresent()) {
            System.out.println("One of the two accounts doesn't exist, can't proceed payment !");
        } else {
            senderAccount.get().removeAmount(amount);
            receiverAccount.get().addAmount(amount);
            bankAccountStorageDB.save(senderAccount.get());
            bankAccountStorageDB.save(receiverAccount.get());
            System.out.println("Payment of " + amount + " euros successfully proceeded between sender with account id "
                    + senderId
                    + " and receiver with account id "
                    + receiverId);
        }
    }

    public boolean addMoney(String userId, float amount) {
        Optional<BankAccountStorage> bankAccountStorage = bankAccountStorageDB.getBankAccountStorageByUserID(userId);
        if (bankAccountStorage.isPresent()) {
            bankAccountStorage.get().addAmount(amount);
            bankAccountStorageDB.save(bankAccountStorage.get());
            System.out.println("Money successfully added to account with user Id " + userId);
            return true;
        } else {
            System.out.println("Couldn't find any account with user Id " + userId);
            return false;
        }
    }
}