package com.codingwithmitch.daggerpractice;

import com.codingwithmitch.daggerpractice.di.component.AppComponent;
import com.codingwithmitch.daggerpractice.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;



/**
 * NEW WAY
 */
public class BaseApplication extends DaggerApplication {


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


///**
// * OLD WAY
// */
//public class BaseApplication extends Application implements HasActivityInjector {
//
//    @Inject
//    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        AppComponent appInjector = DaggerAppComponent.builder().application(this).build();
//        appInjector.inject(this);
//    }
//
//
//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }
//
//}











