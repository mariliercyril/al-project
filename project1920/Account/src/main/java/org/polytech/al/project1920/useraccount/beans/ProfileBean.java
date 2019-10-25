package org.polytech.al.project1920.useraccount.beans;

import org.polytech.al.project1920.useraccount.model.Profile;
import org.polytech.al.project1920.useraccount.model.ProfileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileBean {

    private final
    ProfileDB profileDB;

    @Autowired
    public ProfileBean(ProfileDB profileDB) {
        this.profileDB = profileDB;
        setDB();
    }

    public Profile getProfile(String id) {
        return profileDB.findById(id).orElse(profileDB.findAll().get(0));
    }

    public List<Profile> getProfiles() {
        return profileDB.findAll();
    }

    private void setDB() {
        if (profileDB.findAll().size() == 0) {
            profileDB.save(new Profile(20, 1000));
            profileDB.save(new Profile(45, 66666));
            profileDB.save(new Profile(14, 200));
        }
    }
}
