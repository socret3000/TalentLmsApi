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

import com.abba.talentlmsapi.Interfaces.ILoginP;
import com.abba.talentlmsapi.Interfaces.ILoginView;
import com.abba.talentlmsapi.Models.LoginUser;
import com.abba.talentlmsapi.Presenters.LoginPresenter;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;
import com.abba.talentlmsapi.Util.StringHelpers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText etUser;
    private EditText etPass;
    private Button btnIngresar;

    ILoginP presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser=(EditText)findViewById(R.id.etUser);
        etPass=(EditText)findViewById(R.id.etPass);
        btnIngresar=(Button)findViewById(R.id.btnAceptar);

        presenter=new LoginPresenter(this);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user,pass;
                user=etUser.getText().toString().trim();
                pass=etPass.getText().toString().trim();

                presenter.validate(user,pass);



            }
        });


    }


    @Override
    public void login(String id_user,String id_key) {


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


    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }
}
