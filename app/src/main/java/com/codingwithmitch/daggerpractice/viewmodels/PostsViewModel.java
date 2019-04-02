package com.codingwithmitch.daggerpractice.viewmodels;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    @Inject
    public PostsViewModel() {
        Log.d(TAG, "view model is working...");
    }
}















