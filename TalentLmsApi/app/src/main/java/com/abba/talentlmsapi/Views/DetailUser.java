package com.abba.talentlmsapi.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.abba.talentlmsapi.Interfaces.DetailUserP;
import com.abba.talentlmsapi.Interfaces.IDetailUser;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.Presenters.DetailUserPresenter;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;
import com.abba.talentlmsapi.Util.StringHelpers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailUser extends AppCompatActivity implements IDetailUser {

    Toolbar toolbar;
    TextView txtNombre,txtEmail,txtDescripcion,txtTypeUser,txtCreacion,txtStatus,txtCourses,myCourses;
    String id_user;

    DetailUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        toolbar=(Toolbar)findViewById(R.id.toolbarDetail);
        txtNombre=(TextView)findViewById(R.id.txtNombre);
        txtEmail=(TextView)findViewById(R.id.txtEmail);
        txtDescripcion=(TextView)findViewById(R.id.txtDescripcion);
        txtTypeUser=(TextView)findViewById(R.id.txtTypeUser);
        txtCreacion=(TextView)findViewById(R.id.txtCreacion);
        txtStatus=(TextView)findViewById(R.id.txtStatus);
        txtCourses=(TextView)findViewById(R.id.txtCourses);
        myCourses=(TextView)findViewById(R.id.myCourses);

        setSupportActionBar(toolbar);
        presenter=new DetailUserPresenter(this);

        //getSupportActionBar().setTitle("Usuario");
        getUser();

        myCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goActivity();


            }
        });

    }

    @Override
    public void goActivity() {


        Intent intent=new Intent(DetailUser.this,CoursesUser.class);
        intent.putExtra("id",id_user);
        startActivity(intent);

    }

    @Override
    public void getUser() {

        SharedPreferences prefs = getSharedPreferences(StringHelpers.DATA_USER_LOGIN, MODE_PRIVATE);
        String id_us = prefs.getString("id_user",null);
        String idName = prefs.getString("id_key", null);
        id_user=id_us;


       presenter.getUser(id_user);

    }

    @Override
    public void showUser(String full_name, String email, String descrip, String type_user, String status, String cretateOn) {

        getSupportActionBar().setTitle(full_name);
        txtNombre.setText(full_name);
        txtEmail.setText(email);
        txtDescripcion.setText(descrip);
        txtTypeUser.setText(type_user);
        txtStatus.setText(status);
        txtCreacion.setText(cretateOn);

    }

    @Override
    public void setError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

}
