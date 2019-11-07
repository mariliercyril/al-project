package org.polytech.al.project1920.bankaccount.services;

import org.polytech.al.project1920.bankaccount.beans.BankAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageUserWebService implements IManageUser {
    private final BankAccountBean bankAccountBean;

    @Autowired
    public ManageUserWebService(BankAccountBean bankAccountBean) {
        this.bankAccountBean = bankAccountBean;
    }

    @Override
    @RequestMapping(value = "/getAmount", method = RequestMethod.GET)
    public Float getAmount(@RequestParam String userId) {
        return bankAccountBean.getAmount(userId);
    }

    @Override
    @RequestMapping(value = "/createBankAccount", method = RequestMethod.POST)
    public boolean createAccount(@RequestParam String userId) {
        return bankAccountBean.createAccount(userId);
    }

    @Override
    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public boolean addMoney(@RequestParam String userId, @RequestParam float amount) {
        return bankAccountBean.addMoney(userId, amount);
    }
}
