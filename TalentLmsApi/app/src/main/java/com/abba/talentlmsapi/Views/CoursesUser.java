package com.abba.talentlmsapi.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.abba.talentlmsapi.Adapters.CoursesAdapter;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesUser extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyUsuarios;
    CoursesAdapter adaptador;
    ArrayList<UserCourse> cursos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_user);

        toolbar=(Toolbar)findViewById(R.id.toolbarCoursesUser);
        recyUsuarios=(RecyclerView)findViewById(R.id.recyUsuarios);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mis cursos");

        adaptador=new CoursesAdapter(cursos,R.layout.row_cursos,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyUsuarios.setLayoutManager(linearLayoutManager);
        recyUsuarios.setAdapter(adaptador);


        getData();


    }

    private void getData() {

        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        String id=bundle.getString("id");
        //String name=bundle.getString("name");
       // getSupportActionBar().setTitle(name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.159.15:8080/talentolms/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi service = retrofit.create(UserApi.class);

        Call<User> call=service.getUser(id);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful())
                {

                    Toast.makeText(CoursesUser.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    User user=response.body();
                   // ArrayList<UserCourse> curso=new ArrayList<>();
                    cursos.addAll(user.getCourses());
                    adaptador.notifyDataSetChanged();

                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(CoursesUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}
