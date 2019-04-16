package com.codingwithmitch.daggerpractice.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel: viewmodel is working...");
    }
}









