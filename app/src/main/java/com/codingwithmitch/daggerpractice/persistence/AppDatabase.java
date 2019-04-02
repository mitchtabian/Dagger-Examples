package com.codingwithmitch.daggerpractice.persistence;


import com.codingwithmitch.daggerpractice.models.Post;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_db";

    public abstract PostDao getPostsDao();

}






