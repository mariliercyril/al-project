package org.polytech.al.project1920.card.services;

public interface IRequestTransaction {

	public boolean requestTransaction(String senderAccountId, String receiverAccountId, double amount);

}
