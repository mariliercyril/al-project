package org.polytech.al.project1920.transfer.beans;

import org.polytech.al.project1920.bankaccount.beans.BankAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransfertBean {
    private final BankAccountBean bankAccountBean;

    @Autowired
    public TransfertBean(BankAccountBean bankAccountBean) {
        this.bankAccountBean = bankAccountBean;
    }

    public boolean canPay(String senderId, float amount) {
        return bankAccountBean.canPay(senderId, amount);
    }

    public void pay(String senderId, String receiverId, float amount) {
        bankAccountBean.pay(senderId, receiverId, amount);
    }
}
