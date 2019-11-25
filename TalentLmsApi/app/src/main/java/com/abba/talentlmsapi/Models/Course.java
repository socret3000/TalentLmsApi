package com.abba.talentlmsapi.Models;

public class Course {

    private String id;
    private String name;
    private String code;
    private String category_id;
    private String description;
    private String price;
    private String status;
    private String creation_date;
    private String last_update_on;
    private String creator_id;
    private String hide_from_catalog;
    private String time_limit;
    private Object level;
    private String shared;
    private String shared_url;
    private String avatar;
    private String big_avatar;
    private Object certification;
    private Object certification_duration;


    public Course() {
    }


    public Course(String id, String name, String code, String category_id, String description, String price, String status, String creation_date, String last_update_on, String creator_id, String hide_from_catalog, String time_limit, Object level, String shared, String shared_url, String avatar, String big_avatar, Object certification, Object certification_duration) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.category_id = category_id;
        this.description = description;
        this.price = price;
        this.status = status;
        this.creation_date = creation_date;
        this.last_update_on = last_update_on;
        this.creator_id = creator_id;
        this.hide_from_catalog = hide_from_catalog;
        this.time_limit = time_limit;
        this.level = level;
        this.shared = shared;
        this.shared_url = shared_url;
        this.avatar = avatar;
        this.big_avatar = big_avatar;
        this.certification = certification;
        this.certification_duration = certification_duration;
    }
}
