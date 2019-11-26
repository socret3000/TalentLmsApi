package com.abba.talentlmsapi.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;


import com.abba.talentlmsapi.Adapters.UsersAdapter;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyUsuarios;
    UsersAdapter adaptador;
    List<User> usuarios=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbarMain);
        recyUsuarios=(RecyclerView)findViewById(R.id.recyUsuarios);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Usuarios");

        adaptador=new UsersAdapter(usuarios,R.layout.row_usuario,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyUsuarios.setLayoutManager(linearLayoutManager);
        recyUsuarios.setAdapter(adaptador);

       //getAllUsuarios();
       getUser();


    }
    private void getUser()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.159.15:8080/talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<User> call=service.getUser("13697");


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful())
                {

                    Toast.makeText(MainActivity.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    User user=response.body();
                    usuarios.add(user);
                    adaptador.notifyDataSetChanged();

                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }



    private void getAllUsuarios() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://socret-apps.herokuapp.com/")
                //.baseUrl("http://192.168.159.15:8080/talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<List<User>> call=service.getAllUsers();


        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(!response.isSuccessful())
                {

                    Toast.makeText(MainActivity.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    usuarios.clear();
                    List<User> user=response.body();

                    for(User usuario:user){

                        usuarios.add(usuario);

                    }

                    adaptador.notifyDataSetChanged();


                }


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
