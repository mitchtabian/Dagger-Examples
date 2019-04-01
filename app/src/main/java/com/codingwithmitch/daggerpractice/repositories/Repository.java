package com.codingwithmitch.daggerpractice.repositories;

import android.util.Log;

import com.codingwithmitch.daggerpractice.persistence.FakeDatabase;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private static final String TAG = "Repository";

    private final FakeDatabase fakeDatabase;

    @Inject
    public Repository(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        Log.d(TAG, "Repository: repository is working...");

        if(fakeDatabase == null){
            Log.d(TAG, "Repository: fakeDatabase is null.");
        }
        else{
            Log.d(TAG, "Repository: fakeDatabase is ready to use.\n" + fakeDatabase.testFakeDb());
        }
    }


}









