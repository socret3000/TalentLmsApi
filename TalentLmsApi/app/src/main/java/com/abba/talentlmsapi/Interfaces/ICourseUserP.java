package com.abba.talentlmsapi.Interfaces;

import com.abba.talentlmsapi.Models.UserCourse;

import java.util.ArrayList;

public interface ICourseUserP {

    void getData(String id);

    void showCourses(ArrayList<UserCourse> cursos);

    void setError(String error);
}
