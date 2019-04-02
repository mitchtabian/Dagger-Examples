package com.codingwithmitch.daggerpractice.ui;


import androidx.fragment.app.Fragment;
import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;

import com.codingwithmitch.daggerpractice.R;


public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new PostsFragment());
    }

    public void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }

}













