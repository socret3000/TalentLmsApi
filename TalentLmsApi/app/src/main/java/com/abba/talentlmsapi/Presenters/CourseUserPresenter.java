package com.abba.talentlmsapi.Presenters;

import com.abba.talentlmsapi.Interfaces.DetailUserP;
import com.abba.talentlmsapi.Interfaces.ICourseUser;
import com.abba.talentlmsapi.Interfaces.ICourseUserP;
import com.abba.talentlmsapi.Interfaces.TalentlmsA;
import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.Services.TalentLmsApi;

import java.util.ArrayList;

public class CourseUserPresenter implements ICourseUserP {


    ICourseUser view;
    TalentlmsA service;

    public CourseUserPresenter(ICourseUser view) {
        this.view = view;
        service=new TalentLmsApi(this);

    }

    @Override
    public void getData(String id) {

        service.getCourses(id);


    }

    @Override
    public void showCourses(ArrayList<UserCourse> cursos) {

        view.showCourses(cursos);

    }

    @Override
    public void setError(String error) {

        view.showError(error);

    }


}
