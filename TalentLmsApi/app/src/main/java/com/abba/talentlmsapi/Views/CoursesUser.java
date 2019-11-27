package com.abba.talentlmsapi.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.abba.talentlmsapi.Adapters.CoursesAdapter;
import com.abba.talentlmsapi.Interfaces.ICourseUser;
import com.abba.talentlmsapi.Interfaces.ICourseUserP;
import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.Presenters.CourseUserPresenter;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Services.UserApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesUser extends AppCompatActivity implements ICourseUser {


    Toolbar toolbar;
    RecyclerView recyUsuarios;
    CoursesAdapter adaptador;
    ArrayList<UserCourse> cursos=new ArrayList<>();

    ICourseUserP presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_user);

        toolbar=(Toolbar)findViewById(R.id.toolbarCoursesUser);
        recyUsuarios=(RecyclerView)findViewById(R.id.recyUsuarios);
        presenter=new CourseUserPresenter(this);

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

    @Override
    public void getData() {

        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        String id=bundle.getString("id");
        presenter.getData(id);


    }

    @Override
    public void showCourses(ArrayList<UserCourse> curso) {

        cursos.addAll(curso);
        adaptador.notifyDataSetChanged();

    }

    @Override
    public void showError(String error) {

    }

}
