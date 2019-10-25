package org.polytech.al.project1920.useraccount.services;

import org.polytech.al.project1920.useraccount.model.User;

import java.util.List;

public interface IExtractUserData {
    public User retrieveUser(String userId);

    public List<User> retrieveUsers();
}
