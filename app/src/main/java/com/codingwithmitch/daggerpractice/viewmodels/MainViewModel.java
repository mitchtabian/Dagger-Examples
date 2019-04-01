package com.codingwithmitch.daggerpractice.viewmodels;

import android.util.Log;

import com.codingwithmitch.daggerpractice.repositories.Repository;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    private final Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
        Log.d(TAG, "MainViewModel: view model is working...");
    }
}















