package com.codingwithmitch.daggerpractice.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends BaseActivity  {

    private static final String TAG = "DaggerExample";

//    @Inject
//    @Named("main_string")
//    String someRandomString;

//    @Inject
//    @Named("login_user")
//    User user;

    @Inject
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(TAG, "onCreate: " + someRandomString);
//        Log.d(TAG, "onCreate: authenticated user: " + user.getEmail());

        Log.d(TAG, "onCreate: layout manger: " + layoutManager);

        init();
    }

    private void init(){
        // do not add first fragment to backstack
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new ProfileFragment(), getString(R.string.fragment_profile))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                sessionManager.logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}





















