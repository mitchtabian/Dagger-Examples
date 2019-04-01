package com.codingwithmitch.daggerpractice.persistence;

import android.app.Application;

public class FakeDatabase {

    public FakeDatabase(Application application) {

    }

    public String testFakeDb(){
        return "this is a fake database";
    }
}
