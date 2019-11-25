package com.abba.talentlmsapi.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abba.talentlmsapi.Util.StringHelpers;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SharedPreferences prefs = getSharedPreferences(StringHelpers.DATA_USER_LOGIN, MODE_PRIVATE);
        String id_user = prefs.getString("id_user",null);
        String idName = prefs.getString("id_key", null);

        if(id_user!=null)
        {
            Intent intent=new Intent(SplashActivity.this,DetailUser.class);
            intent.putExtra("id",id_user);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        }
        else
        {
            Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        }


    }
}
