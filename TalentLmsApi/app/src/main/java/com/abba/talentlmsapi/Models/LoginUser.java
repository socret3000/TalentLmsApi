package com.abba.talentlmsapi.Models;

public class LoginUser {

    private String user_id;
    private String login_key;

    public LoginUser() {
    }

    public LoginUser(String user_id, String login_key) {
        this.user_id = user_id;
        this.login_key = login_key;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLogin_key() {
        return login_key;
    }

    public void setLogin_key(String login_key) {
        this.login_key = login_key;
    }
}
