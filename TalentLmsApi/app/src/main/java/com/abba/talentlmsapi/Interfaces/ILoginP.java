package com.abba.talentlmsapi.Interfaces;

public interface ILoginP {

    void login(String id_user,String key);

    void validate(String user, String pass);

    void setError(String error);

}
