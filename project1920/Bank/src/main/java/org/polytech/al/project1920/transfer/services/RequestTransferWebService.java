package org.polytech.al.project1920.transfer.services;

import org.polytech.al.project1920.transfer.beans.TransfertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTransferWebService implements IRequestTransfert{

    private TransfertBean transfertBean;

    @Autowired
    public RequestTransferWebService(TransfertBean transfertBean) {
        this.transfertBean = transfertBean;
    }

    @Override
    @RequestMapping(value = "/requestTransfer", method = RequestMethod.POST)
    public boolean requestTransfer(@RequestParam String senderId, @RequestParam String receiverId, @RequestParam float amount) {
        if (transfertBean.canPay(senderId, amount)) {
            transfertBean.pay(senderId, receiverId, amount);
            return true;
        }
        System.out.println("Can't proceed payment, you don't have enough money !");
        return false;
    }
}
