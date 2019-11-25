package com.abba.talentlmsapi.Services;

import com.abba.talentlmsapi.Models.LoginUser;
import com.abba.talentlmsapi.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserApi {

    @GET("user.php")
    Call<List<User>> getAllUsers();

    @GET("user.php")
    Call<User> getUser(@Query("id") String id);

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginUser> setLogin(@Field("userName") String userName,@Field("password") String password);




}
