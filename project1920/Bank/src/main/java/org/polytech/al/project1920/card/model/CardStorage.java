package org.polytech.al.project1920.card.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CardStorageDB")
public class CardStorage {

	@Id
	private String id;
	private String userID;

	public CardStorage(String userID) {

		this.userID = userID;
	}

	public String getId() {

		return id;
	}

	public String getUserID() {

		return userID;
	}

	public void setUserID(String userID) {

		this.userID = userID;
	}

}
