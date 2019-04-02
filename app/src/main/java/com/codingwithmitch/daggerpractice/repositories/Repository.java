package com.codingwithmitch.daggerpractice.repositories;

import android.util.Log;

import com.codingwithmitch.daggerpractice.persistence.PostDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private static final String TAG = "Repository";

    private final PostDao postDao;

    @Inject
    public Repository(PostDao postDao) {
        this.postDao = postDao;
        Log.d(TAG, "Repository: repository is working...");

        if(postDao == null){
            Log.d(TAG, "Repository: dao is null.");
        }
        else{
            Log.d(TAG, "Repository: dao is ready to use.");
        }
    }


}









