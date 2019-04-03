package com.codingwithmitch.daggerpractice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.codingwithmitch.daggerpractice.di.AppComponent;
import com.codingwithmitch.daggerpractice.di.DaggerAppComponent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerApplication;


/**
 * NEW WAY
 */
public class BaseApplication extends DaggerApplication {


    private static final String TAG = "BaseApplication";

    private final AppComponent appInjector = DaggerAppComponent.builder().application(this).build();

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return appInjector;
    }


}











