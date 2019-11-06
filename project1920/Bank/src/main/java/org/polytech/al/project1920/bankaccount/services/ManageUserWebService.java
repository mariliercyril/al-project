package org.polytech.al.project1920.bankaccount.services;

import org.polytech.al.project1920.bankaccount.beans.BankAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManageUserWebService implements IManageUser {
    private final
    BankAccountBean bankAccountBean;

    @Autowired
    public ManageUserWebService(BankAccountBean bankAccountBean) {
        this.bankAccountBean = bankAccountBean;
    }

    @Override
    @RequestMapping(value = "/getAmounts", method = RequestMethod.GET)
    public List<Float> getAmounts(@RequestParam String userId) {
        return bankAccountBean.getAmounts(userId);
    }

    @Override
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public void createAccount(@RequestParam String userId) {
        bankAccountBean.createAccount(userId);
    }
}
