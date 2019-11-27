package com.abba.talentlmsapi.Interfaces;

import com.abba.talentlmsapi.Models.UserCourse;

import java.util.ArrayList;

public interface ICourseUser {

    void getData();

    void showCourses(ArrayList<UserCourse> cursos);

    void showError(String error);
}
