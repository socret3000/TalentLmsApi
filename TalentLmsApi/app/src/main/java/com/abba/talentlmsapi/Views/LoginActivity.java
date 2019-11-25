package com.abba.talentlmsapi.Views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abba.talentlmsapi.Models.LoginUser;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;
import com.abba.talentlmsapi.Util.StringHelpers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;
    private Button btnIngresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser=(EditText)findViewById(R.id.etUser);
        etPass=(EditText)findViewById(R.id.etPass);
        btnIngresar=(Button)findViewById(R.id.btnAceptar);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user,pass;
                user=etUser.getText().toString().trim();
                pass=etPass.getText().toString().trim();

                if(user!=null && !user.equals(""))
                {

                    if(pass!=null && !pass.equals(""))
                    {

                        validateLogin(user,pass);

                    }
                    else
                    {
                        etPass.setError("Ingrese un password");
                    }
                }
                else
                {
                    etUser.setError("Ingrese su nombre de usuario");
                }

            }
        });


    }

    private void validateLogin(String user, String pass) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.159.15:8080/talentolms/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UserApi service = retrofit.create(UserApi.class);

            Call<LoginUser> call=service.setLogin(user,pass);

            call.enqueue(new Callback<LoginUser>() {
                @Override
                public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {

                    Log.e("response",response.body().toString());

                    if(!response.isSuccessful())
                    {

                        Toast.makeText(LoginActivity.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else
                    {
                        LoginUser user=response.body();
                        if(user!=null)
                        {
                            Log.e("userId",user.getUser_id());
                            Log.e("userKey",user.getLogin_key());
                            String userId=user.getUser_id();
                            String key=user.getLogin_key();
                            if(!userId.equals("") && !key.equals(""))
                            {

                                login(userId,key);

                            }

                        }

                    }

                }

                @Override
                public void onFailure(Call<LoginUser> call, Throwable t) {

                    Toast.makeText(LoginActivity.this, "No se pudo ingresar", Toast.LENGTH_SHORT).show();

                }
            });


    }

    private void login(String id_user,String id_key) {

        SharedPreferences.Editor editor = getSharedPreferences(StringHelpers.DATA_USER_LOGIN, MODE_PRIVATE).edit();
        editor.putString("id_user", id_user);
        editor.putString("id_key", id_key);
        editor.apply();

        Intent intent=new Intent(LoginActivity.this,DetailUser.class);
        intent.putExtra("id",id_user);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }





}
