package com.abba.talentlmsapi.Presenters;

import android.content.Intent;
import android.content.SharedPreferences;

import com.abba.talentlmsapi.Interfaces.ILoginP;
import com.abba.talentlmsapi.Interfaces.ILoginView;
import com.abba.talentlmsapi.Interfaces.TalentlmsA;
import com.abba.talentlmsapi.Services.TalentLmsApi;
import com.abba.talentlmsapi.Util.StringHelpers;
import com.abba.talentlmsapi.Views.DetailUser;
import com.abba.talentlmsapi.Views.LoginActivity;

public class LoginPresenter implements ILoginP {

    ILoginView view;
    TalentlmsA service;


    public LoginPresenter(ILoginView view) {
        this.view = view;
        service=new TalentLmsApi(this);


    }

    @Override
    public void login(String id_user,String key) {


        view.login(id_user,key);


    }


    @Override
    public void validate(String user, String pass) {

        if(user!=null && !user.equals(""))
        {

            if(pass!=null && !pass.equals(""))
            {

                service.validateLogin(user,pass);

            }
            else
            {
                view.showError("Ingrese un password");
            }
        }
        else
        {
            view.showError("Ingrese su nombre de usuario");
        }

    }

    @Override
    public void setError(String error) {

        view.showError(error);

    }
}
