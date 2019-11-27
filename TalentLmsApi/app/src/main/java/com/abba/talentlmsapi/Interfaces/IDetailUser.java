package com.abba.talentlmsapi.Interfaces;

import com.abba.talentlmsapi.Models.User;

public interface IDetailUser {

    void goActivity();

    void getUser();

    void showUser(String full_name,String email,String descrip,String type_user,String status,String cretateOn);

    void setError(String error);


}
