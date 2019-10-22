package org.polytech.al.project1920.bankaccount.services;

public interface IConnect {

	public boolean getInfos(String AccountId);

	public boolean canPayTransfer(String accountId, double amount);

	public boolean canPayCard(String accountId, double amount);

}
