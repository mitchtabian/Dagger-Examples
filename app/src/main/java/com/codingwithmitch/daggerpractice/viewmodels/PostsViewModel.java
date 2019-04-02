package com.codingwithmitch.daggerpractice.viewmodels;

import android.util.Log;

import com.codingwithmitch.daggerpractice.repositories.Repository;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private final Repository repository;

    @Inject
    public PostsViewModel(Repository repository) {
        this.repository = repository;
        Log.d(TAG, "view model is working...");
    }
}















