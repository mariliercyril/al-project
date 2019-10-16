package org.polytech.al.project1920.bankaccount.services;

import org.polytech.al.project1920.transfer.beans.TransfertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageUserWebService implements IManageUser {

    //private TransfertBean transfertBean;

    /*@Autowired
    public ManageUserWebService(TransfertBean transfertBean) {
        this.transfertBean = transfertBean;
    }*/

    @Override
    @RequestMapping(value = "/getInfos", method = RequestMethod.GET)
    public boolean getInfos(@RequestParam String accountId) {
        System.out.println("Bank in getInfos");
        return true;
    }
}
