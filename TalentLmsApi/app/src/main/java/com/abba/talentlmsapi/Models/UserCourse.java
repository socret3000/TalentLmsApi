package com.abba.talentlmsapi.Models;

public class UserCourse {

    String id;
    String name;
    String role;
    String enrolled_on;
    String enrolled_on_timestamp;
    String completed_on;
    String completed_on_timestamp;
    String completion_status;
    String completion_percentage;
    String expired_on;
    String expired_on_timestamp;
    String total_time;


    public UserCourse() {
    }

    public UserCourse(String id, String name, String role, String enrolled_on, String enrolled_on_timestamp, String completed_on, String completed_on_timestamp, String completion_status, String completion_percentage, String expired_on, String expired_on_timestamp, String total_time) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.enrolled_on = enrolled_on;
        this.enrolled_on_timestamp = enrolled_on_timestamp;
        this.completed_on = completed_on;
        this.completed_on_timestamp = completed_on_timestamp;
        this.completion_status = completion_status;
        this.completion_percentage = completion_percentage;
        this.expired_on = expired_on;
        this.expired_on_timestamp = expired_on_timestamp;
        this.total_time = total_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEnrolled_on() {
        return enrolled_on;
    }

    public void setEnrolled_on(String enrolled_on) {
        this.enrolled_on = enrolled_on;
    }

    public String getEnrolled_on_timestamp() {
        return enrolled_on_timestamp;
    }

    public void setEnrolled_on_timestamp(String enrolled_on_timestamp) {
        this.enrolled_on_timestamp = enrolled_on_timestamp;
    }

    public String getCompleted_on() {
        return completed_on;
    }

    public void setCompleted_on(String completed_on) {
        this.completed_on = completed_on;
    }

    public String getCompleted_on_timestamp() {
        return completed_on_timestamp;
    }

    public void setCompleted_on_timestamp(String completed_on_timestamp) {
        this.completed_on_timestamp = completed_on_timestamp;
    }

    public String getCompletion_status() {
        return completion_status;
    }

    public void setCompletion_status(String completion_status) {
        this.completion_status = completion_status;
    }

    public String getCompletion_percentage() {
        return completion_percentage;
    }

    public void setCompletion_percentage(String completion_percentage) {
        this.completion_percentage = completion_percentage;
    }

    public String getExpired_on() {
        return expired_on;
    }

    public void setExpired_on(String expired_on) {
        this.expired_on = expired_on;
    }

    public String getExpired_on_timestamp() {
        return expired_on_timestamp;
    }

    public void setExpired_on_timestamp(String expired_on_timestamp) {
        this.expired_on_timestamp = expired_on_timestamp;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }
}
