package com.codingwithmitch.daggerpractice.persistence.posts;

import com.codingwithmitch.daggerpractice.ui.main.posts.Post;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PostDao {

    @Query("SELECT * FROM posts")
    LiveData<List<Post>> getAllPosts();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosts(Post... posts);
}
