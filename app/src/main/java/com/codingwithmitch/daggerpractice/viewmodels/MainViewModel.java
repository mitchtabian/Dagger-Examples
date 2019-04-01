package com.codingwithmitch.daggerpractice.viewmodels;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    @Inject
    public MainViewModel() {
        Log.d(TAG, "MainViewModel: view model is working.");
    }
}















