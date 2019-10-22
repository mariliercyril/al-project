package org.polytech.al.project1920.transfer.beans;

import org.polytech.al.project1920.bankaccount.beans.BankAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class TransfertBean {

    private final
    BankAccountBean bankAccountBean;

    @Autowired
    public TransfertBean(BankAccountBean bankAccountBean) {
        this.bankAccountBean = bankAccountBean;
    }

    public boolean requestTransfer(String senderAccountId, String receiverAccountId, double amount){
        return  bankAccountBean.canPayTransfert(senderAccountId, amount);
    }
}
