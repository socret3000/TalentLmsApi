

package com.abba.talentlmsapi.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class User {

    private String id;
    private String login;
    private String first_name;
    private String last_name;
    private String email;
    private String restrict_email;
    private String user_type;
    private String timezone;
    private String language;
    private String status;
    private String deactivation_date;
    private String level;
    private String points;
    private String created_on;
    private String last_updated;
    private String last_updated_timestamp;
    private String avatar;
    private Object bio;
    private String login_key;
    private ArrayList<UserCourse> courses;




    public User() {
    }

    public User(String id, String login, String first_name, String last_name, String email, String restrict_email, String user_type, String timezone, String language, String status, String deactivation_date, String level, String points, String created_on, String last_updated, String last_updated_timestamp, String avatar, Object bio, String login_key, ArrayList<UserCourse> courses) {
        this.id = id;
        this.login = login;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.restrict_email = restrict_email;
        this.user_type = user_type;
        this.timezone = timezone;
        this.language = language;
        this.status = status;
        this.deactivation_date = deactivation_date;
        this.level = level;
        this.points = points;
        this.created_on = created_on;
        this.last_updated = last_updated;
        this.last_updated_timestamp = last_updated_timestamp;
        this.avatar = avatar;
        this.bio = bio;
        this.login_key = login_key;
        this.courses = courses;
    }

    public User(String id, String login, String first_name, String last_name, String email, String restrict_email, String user_type, String timezone, String language, String status, String deactivation_date, String level, String points, String created_on, String last_updated, String last_updated_timestamp, String avatar, Object bio, String login_key) {
        this.id = id;
        this.login = login;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.restrict_email = restrict_email;
        this.user_type = user_type;
        this.timezone = timezone;
        this.language = language;
        this.status = status;
        this.deactivation_date = deactivation_date;
        this.level = level;
        this.points = points;
        this.created_on = created_on;
        this.last_updated = last_updated;
        this.last_updated_timestamp = last_updated_timestamp;
        this.avatar = avatar;
        this.bio = bio;
        this.login_key = login_key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRestrict_email() {
        return restrict_email;
    }

    public void setRestrict_email(String restrict_email) {
        this.restrict_email = restrict_email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeactivation_date() {
        return deactivation_date;
    }

    public void setDeactivation_date(String deactivation_date) {
        this.deactivation_date = deactivation_date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getLast_updated_timestamp() {
        return last_updated_timestamp;
    }

    public void setLast_updated_timestamp(String last_updated_timestamp) {
        this.last_updated_timestamp = last_updated_timestamp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public String getLogin_key() {
        return login_key;
    }

    public void setLogin_key(String login_key) {
        this.login_key = login_key;
    }

    public ArrayList<UserCourse> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<UserCourse> courses) {
        this.courses = courses;
    }
}