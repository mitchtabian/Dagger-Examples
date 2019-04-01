package com.codingwithmitch.daggerpractice.repositories;

import android.util.Log;

import com.codingwithmitch.daggerpractice.persistence.RecipeDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private static final String TAG = "Repository";

    private final RecipeDao recipeDao;

    @Inject
    public Repository(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
        Log.d(TAG, "Repository: repository is working...");

        if(recipeDao == null){
            Log.d(TAG, "Repository: dao is null.");
        }
        else{
            Log.d(TAG, "Repository: dao is ready to use.");
        }
    }


}









