package org.polytech.al.project1920.useraccount.services;

import org.polytech.al.project1920.useraccount.beans.ProfileBean;
import org.polytech.al.project1920.useraccount.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtractUserData implements IExtractUserData {

    private final
    ProfileBean profileBean;

    @Autowired
    public ExtractUserData(ProfileBean profileBean) {
        this.profileBean = profileBean;
    }

    @Override
    @RequestMapping(value = "/retrieveProfile", method = RequestMethod.GET)
    public Profile retrieveProfile(@RequestParam String profileId) {
        System.out.println(profileId);
        System.out.println(profileId);
        System.out.println(profileId);
        return profileBean.getProfile(profileId);
    }
}
