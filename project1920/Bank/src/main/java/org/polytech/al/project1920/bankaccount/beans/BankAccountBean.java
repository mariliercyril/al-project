package org.polytech.al.project1920.bankaccount.beans;

import org.springframework.stereotype.Repository;

@Repository
public class BankAccountBean {

    public boolean canPayTransfert(String senderAccountId, double amount){
        return true;
    }
}
