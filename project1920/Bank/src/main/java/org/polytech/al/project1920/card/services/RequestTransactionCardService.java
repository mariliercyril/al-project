package org.polytech.al.project1920.card.services;

import org.polytech.al.project1920.card.beans.CardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTransactionCardService implements IRequestTransaction {
    private CardBean cardBean;

    @Autowired
    public RequestTransactionCardService(CardBean cardBean) {
        this.cardBean = cardBean;
    }

    @Override
    @RequestMapping(value = "/requestTransaction", method = RequestMethod.POST)
    public boolean requestTransaction(@RequestParam String senderId, @RequestParam String receiverId, @RequestParam float amount) {
        if (cardBean.canPay(senderId, amount)) {
            cardBean.pay(senderId, receiverId, amount);
            return true;
        }
        System.out.println("Can't proceed payment, you don't have enough money !");
        return false;
    }
}
