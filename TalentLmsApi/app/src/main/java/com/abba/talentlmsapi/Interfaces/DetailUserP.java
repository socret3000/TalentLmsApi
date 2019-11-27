package com.abba.talentlmsapi.Interfaces;

import com.abba.talentlmsapi.Models.User;

public interface DetailUserP {

    void getUser(String id);

    void showUser(User user);

    void setError(String error);
}
