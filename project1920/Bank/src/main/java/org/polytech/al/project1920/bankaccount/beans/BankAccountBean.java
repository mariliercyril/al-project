package org.polytech.al.project1920.bankaccount.beans;

import org.polytech.al.project1920.bankaccount.model.BankAccountStorage;
import org.polytech.al.project1920.bankaccount.model.BankAccountStorageDB;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class BankAccountBean {

    private final
    BankAccountStorageDB bankAccountStorageDB;

    @Autowired
    public BankAccountBean(BankAccountStorageDB bankAccountStorageDB) {

        this.bankAccountStorageDB = bankAccountStorageDB;
    }

    public boolean getInfos(String senderAccountId) {

        BankAccountStorage a = new BankAccountStorage(senderAccountId);
        bankAccountStorageDB.save(a);
        System.out.println(bankAccountStorageDB.findAll().size());
        return true;
    }

    public boolean canPayTransfert(String senderAccountId, double amount) {

        return true;
    }

    public boolean canPayCard(String senderAccountId, double amount) {

        return true;
    }

}
