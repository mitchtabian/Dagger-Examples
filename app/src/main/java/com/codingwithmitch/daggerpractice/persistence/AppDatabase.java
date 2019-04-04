package com.codingwithmitch.daggerpractice.persistence;


import com.codingwithmitch.daggerpractice.persistence.posts.PostDao;
import com.codingwithmitch.daggerpractice.persistence.todos.TodoDao;
import com.codingwithmitch.daggerpractice.ui.main.posts.Post;
import com.codingwithmitch.daggerpractice.ui.main.todos.Todo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Post.class, Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_db";

    public abstract PostDao getPostsDao();

    public abstract TodoDao getTodosDao();

}






