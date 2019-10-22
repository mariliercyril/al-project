package org.polytech.al.project1920.useraccount.services;

import org.polytech.al.project1920.useraccount.beans.UserAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataUIWebService implements IDataUI {

    private UserAccountBean userAccountBean;

    @Autowired
    public DataUIWebService(UserAccountBean userAccountBean) {
        this.userAccountBean = userAccountBean;
    }

    @Override
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public boolean getData(@RequestParam String accountId) {
        System.out.println("Account in getData");
        return userAccountBean.getData(accountId);
    }
}
