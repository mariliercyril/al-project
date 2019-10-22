package org.polytech.al.project1920.card.beans;

import org.polytech.al.project1920.bankaccount.beans.BankAccountBean;
import org.polytech.al.project1920.card.model.CardStorage;
import org.polytech.al.project1920.card.model.CardStorageDB;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class CardBean {

	private final BankAccountBean bankAccountBean;

	@Autowired
	public CardBean(BankAccountBean bankAccountBean) {

		this.bankAccountBean = bankAccountBean;
	}

	public boolean requestTransaction(String senderAccountId, String receiverAccountId, double amount) {

		return  bankAccountBean.canPayCard(senderAccountId, amount);
	}

}
