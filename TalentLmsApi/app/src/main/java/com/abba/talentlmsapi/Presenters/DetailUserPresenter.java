package com.abba.talentlmsapi.Presenters;

import com.abba.talentlmsapi.Interfaces.DetailUserP;
import com.abba.talentlmsapi.Interfaces.IDetailUser;
import com.abba.talentlmsapi.Interfaces.TalentlmsA;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Services.TalentLmsApi;

public class DetailUserPresenter implements DetailUserP
{

    IDetailUser view;
    TalentlmsA service;

    public DetailUserPresenter(IDetailUser view) {
        this.view = view;
        service=new TalentLmsApi(this);
    }

    @Override
    public void getUser(String id) {

        service.getUser(id);

    }

    @Override
    public void showUser(User user) {



        String Full_name=user.getFirst_name()+" "+user.getLast_name();

        String email=user.getEmail();
        String desrip=String.valueOf(user.getBio());
        String type_user=user.getUser_type();
        String status=user.getStatus();
        String created=user.getCreated_on();

        view.showUser(Full_name,email,desrip,type_user,status,created);


    }

    @Override
    public void setError(String error) {

        view.setError(error);

    }


}
