package org.polytech.al.project1920.card.services;

import org.polytech.al.project1920.card.beans.CardBean;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTransactionCardService implements IRequestTransaction {

	private CardBean cardBean;

	@Autowired
	public RequestTransactionCardService(CardBean cardBean) {

		this.cardBean = cardBean;
	}

	@Override
	@PostMapping(path = "/requestTransactions", consumes = "application/json", produces = "application/json")
	public boolean requestTransaction(String senderAccountId, String receiverAccountId, double amount) {

		return cardBean.requestTransaction(senderAccountId, receiverAccountId, amount);
	}

}
