package org.polytech.al.project1920.useraccount.services;

import org.polytech.al.project1920.useraccount.model.Profile;

public interface IExtractUserData {
    public Profile retrieveProfile(String profileId);
}
