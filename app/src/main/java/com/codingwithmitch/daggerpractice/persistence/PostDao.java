package com.codingwithmitch.daggerpractice.persistence;

import com.codingwithmitch.daggerpractice.models.Post;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface PostDao {

    @Query("SELECT * FROM posts")
    LiveData<List<Post>> getAllPosts();


}
