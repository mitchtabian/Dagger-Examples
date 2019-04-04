package com.codingwithmitch.daggerpractice;

import android.app.Activity;
import android.os.Bundle;

import com.codingwithmitch.daggerpractice.di.AppComponent;
import com.codingwithmitch.daggerpractice.di.DaggerAppComponent;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
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

        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AndroidInjection.inject(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return appInjector;
    }


}











