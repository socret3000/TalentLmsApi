package com.abba.talentlmsapi.Services;

import android.util.Log;
import android.widget.Toast;

import com.abba.talentlmsapi.Interfaces.DetailUserP;
import com.abba.talentlmsapi.Interfaces.ICourseUserP;
import com.abba.talentlmsapi.Interfaces.ILoginP;
import com.abba.talentlmsapi.Interfaces.TalentlmsA;
import com.abba.talentlmsapi.Models.LoginUser;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.Views.LoginActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TalentLmsApi implements TalentlmsA {

    DetailUserP presenter;
    ILoginP loginPresenter;
    ICourseUserP courseUPresenter;
    public static final String url = "http://192.168.159.15:8080/";
    User user;


    public TalentLmsApi(ICourseUserP courseUPresenter) {
        this.courseUPresenter = courseUPresenter;
    }

    public TalentLmsApi(DetailUserP presenter) {
        this.presenter = presenter;
    }


    public TalentLmsApi(ILoginP loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void getUser(String id) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url + "talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<User> call = service.getUser(id);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    presenter.setError("Error " + response.code());

                    return;
                } else {

                    user = response.body();
                    presenter.showUser(user);


                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                presenter.setError(t.getMessage());

            }
        });




    }

    @Override
    public void validateLogin(String user, String pass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url + "talentolms/")
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

                   // Toast.makeText(LoginActivity.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    loginPresenter.setError("Error: "+response.code());

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

                            loginPresenter.login(userId,key);

                        }

                    }

                }

            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {

                loginPresenter.setError("No se pudo ingresar");

            }
        });


    }

    @Override
    public void getCourses(String id) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url + "talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<User> call=service.getUser(id);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful())
                {

                   courseUPresenter.setError("Error: "+response.code());


                    return;
                }
                else
                {

                    User user=response.body();
                    ArrayList<UserCourse> cursos=new ArrayList<>();

                    cursos.addAll(user.getCourses());
                    courseUPresenter.showCourses(cursos);

                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                courseUPresenter.setError(t.getMessage());

            }
        });

    }

}

