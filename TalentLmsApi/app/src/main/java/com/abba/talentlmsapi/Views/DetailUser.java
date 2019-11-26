package com.abba.talentlmsapi.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Models.UserCourse;
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

public class DetailUser extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtNombre,txtEmail,txtDescripcion,txtTypeUser,txtCreacion,txtStatus,txtCourses,myCourses;
    String id_user;

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
        //getSupportActionBar().setTitle("Usuario");
        getUser();

        myCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DetailUser.this,CoursesUser.class);
                intent.putExtra("id",id_user);
                startActivityForResult(intent,1000);

            }
        });

    }

    private void getUser() {


        SharedPreferences prefs = getSharedPreferences(StringHelpers.DATA_USER_LOGIN, MODE_PRIVATE);
        String id_us = prefs.getString("id_user",null);
        String idName = prefs.getString("id_key", null);
        id_user=id_us;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.159.15:8080/talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<User> call=service.getUser(id_user);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful())
                {

                    Toast.makeText(DetailUser.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    User user=response.body();
                    String Full_name=user.getFirst_name()+" "+user.getLast_name();
                    getSupportActionBar().setTitle(Full_name);
                    txtNombre.setText(Full_name);
                    txtEmail.setText(user.getEmail());
                    txtDescripcion.setText(String.valueOf(user.getBio()));
                    txtTypeUser.setText(user.getUser_type());
                    txtStatus.setText(user.getStatus());
                    txtCreacion.setText(user.getCreated_on());



                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(DetailUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }
}
