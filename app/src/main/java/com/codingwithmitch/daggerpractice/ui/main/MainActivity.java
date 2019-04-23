package com.codingwithmitch.daggerpractice.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileFragment;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new ProfileFragment())
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

























