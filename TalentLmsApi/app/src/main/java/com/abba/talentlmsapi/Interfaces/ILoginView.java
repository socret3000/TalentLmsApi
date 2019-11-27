package com.abba.talentlmsapi.Interfaces;

public interface ILoginView {

    void login(String id_user,String key);

    void showError(String error);
}
