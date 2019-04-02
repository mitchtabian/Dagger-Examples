package com.codingwithmitch.daggerpractice.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class Post {

    @PrimaryKey
    @NonNull
    private int user_id;
    private int id;
    private String title;
    private String body;


    public Post(int user_id, int id, String title, String body) {
        this.user_id = user_id;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Ignore
    public Post() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}









