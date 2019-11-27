package com.abba.talentlmsapi.Interfaces;

import com.abba.talentlmsapi.Models.User;

public interface TalentlmsA  {

    void getUser(String id);

    void validateLogin(String user, String pass);

    void getCourses(String id);

}
